

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class commitTesting {

	public static void main(String[] args) throws IOException, IllegalStateException, GitAPIException
	{
		Git git = Git.open( new File( "./java-new-repo/.git" ) );
		org.eclipse.jgit.api.AddCommand cmd = git.add();
		cmd.addFilepattern("testfile");
		cmd.call();

		org.eclipse.jgit.api.CommitCommand commitCmd = git.commit();
		commitCmd.setAuthor("author", "author@something");
		commitCmd.setMessage("commit message");
		commitCmd.call();
	}
}