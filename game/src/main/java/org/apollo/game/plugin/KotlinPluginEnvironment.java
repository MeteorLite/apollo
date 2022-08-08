package org.apollo.game.plugin;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import org.apollo.game.model.World;
import org.apollo.game.plugin.kotlin.KotlinPluginScript;

public class KotlinPluginEnvironment implements PluginEnvironment {

  private static final Logger logger = Logger.getLogger(KotlinPluginEnvironment.class.getName());
  private static final String PLUGIN_SUFFIX = "_plugin";

  private final World world;
  private PluginContext context;

  public KotlinPluginEnvironment(World world) {
    this.world = world;
  }

  private static String pluginDescriptor(Class<? extends KotlinPluginScript> clazz) {
    String className = clazz.getSimpleName();
    String name = className.substring(0, className.length() - PLUGIN_SUFFIX.length());
    Package pkg = clazz.getPackage();

    return pkg == null ? name : name + " from " + pkg.getName();
  }

  @Override
  public void load(Collection<PluginMetaData> plugins) {
    List<KotlinPluginScript> pluginScripts = new ArrayList<>();

    ClassGraph classGraph = new ClassGraph().enableAllInfo();

    int count = 0;

    try (ScanResult scanResult = classGraph.scan()) {
      ClassInfoList pluginClassList = scanResult
          .getSubclasses(KotlinPluginScript.class.getName())
          .directOnly();

      for (ClassInfo pluginClassInfo : pluginClassList) {
        Class<KotlinPluginScript> scriptClass = pluginClassInfo.loadClass(KotlinPluginScript.class);
        Constructor<KotlinPluginScript> scriptConstructor = scriptClass.getConstructor(World.class,
            PluginContext.class);
        count++;
        pluginScripts.add(scriptConstructor.newInstance(world, context));
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    pluginScripts.forEach(script -> script.doStart(world));
    logger.info("Loaded " + count + " plugins");
  }

  @Override
  public void setContext(PluginContext context) {
    this.context = context;
  }
}
