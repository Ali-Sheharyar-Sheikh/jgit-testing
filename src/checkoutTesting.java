
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class checkoutTesting {

	public static void main(String[] args) throws IOException,
			IllegalStateException, GitAPIException {
		Git git = Git.open(new File("./java-new-repo/.git"));
		git.checkout().setName("master").call();
		System.out.println("master checked out successfully");
	}
}