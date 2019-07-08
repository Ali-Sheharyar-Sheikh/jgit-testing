
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class branchTesting {

	public static void main(String[] args) throws IOException,
			IllegalStateException, GitAPIException {
		Git git = Git.open(new File("./java-new-repo/.git"));
		git.branchCreate().setName("test-branch").setStartPoint("test-tag")
				.call();
		System.out.println("branch created successfully");
	}
}