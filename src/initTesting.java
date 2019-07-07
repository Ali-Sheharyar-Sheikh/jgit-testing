import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;

public class initTesting {

	public static void main(String[] args) throws IOException, IllegalStateException, GitAPIException
	{

		System.out.println("Welcome to jgit examples!");

		// create the directory
		try  
		{
			Git git = Git.init().setDirectory(new File("./java-new-repo/")).call();
			System.out.println("Having repository: " + git.getRepository().getDirectory());
			
			Status status = git.status().call();

            Set<String> added = status.getAdded();
            for (String add : added) {
                System.out.println("Added: " + add);
            }
			
			File myFile = new File(git.getRepository().getDirectory().getParent(), "testfile");
            if (!myFile.createNewFile()) {
                throw new IOException("Could not create file " + myFile);
            }

            // run the add-call
            git.add().addFilepattern("testfile").call();

            git.commit().setMessage("Initial commit").call();

			System.out.println("Committed file!");
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}
}