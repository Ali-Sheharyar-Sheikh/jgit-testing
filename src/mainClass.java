import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;


public class mainClass {

	public static void main(String[] args) {

		try{
			Git.cloneRepository()
			  .setURI("C:\\Users\\Alis\\Documents\\Visual Studio 2017\\Projects\\gitlib2-testing-cpp\\origin-master")
			  .setDirectory(new File("./java-local-repo-clone-testing/"))
			  .call();
			System.out.println("Repository cloned successfully!");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
