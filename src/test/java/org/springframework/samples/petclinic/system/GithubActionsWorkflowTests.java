package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GithubActionsWorkflowTests {

	@Test
	void gradleWorkflowRunsOnFixBranchPushes() throws Exception {
		String workflow = Files.readString(Path.of(".github/workflows/gradle-build.yml"));
		String pushTrigger = workflow.split("pull_request:", 2)[0];

		assertTrue(pushTrigger.contains("branches: [ main, 'fix/**' ]"),
				"Gradle CI push filter must include fix/** branches");
	}

}
