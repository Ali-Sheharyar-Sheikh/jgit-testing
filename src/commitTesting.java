

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class commitTesting {

	public static void main(String[] args) throws IOException, IllegalStateException, GitAPIException
	{
		Git git = Git.open( new File( "./java-new-repo/.git" ) );
		git.add().addFilepattern("testfile2").call();
		git.commit().setAuthor("author", "author@something").setMessage("commit 2 message").call();
		System.out.println("commit successfull!");
	}
}