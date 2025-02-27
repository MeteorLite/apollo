package org.apollo.game.plugin.detekt.rules

import io.gitlab.arturbosch.detekt.test.lint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Paths

internal class DeclarationInScriptRuleTest {
    val rule = DeclarationInScriptRule()

    @Test
    fun `Finds warning in script file`() {
        val srcPath = Paths.get(this.javaClass.getResource("/testData/example.kts").toURI())
        val findings = rule.lint(srcPath)

        assertEquals(1, findings.size)
        assertEquals(
            "Declaration of ExampleDeclaration should live in a top-level file, not a script",
            findings[0].message
        )
    }
}