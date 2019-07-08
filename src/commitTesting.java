
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class commitTesting {

	public static void main(String[] args) throws IOException,
			IllegalStateException, GitAPIException {
		long startTime = System.currentTimeMillis();
		Git git = Git.open(new File(".git"));
		git.add().addFilepattern(".").call();
		git.commit().setMessage("commit message").call();
		long endTime = System.currentTimeMillis();
		System.out.println("commit successful in "+ (endTime-startTime)/1000. + " sec");
		
	}
}