import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class initTesting {

	public static void main(String[] args) throws IOException,
			IllegalStateException, GitAPIException {
		try {
			long startTime = System.currentTimeMillis();

			Git git = Git.init().setDirectory(new File(".")).call();

			System.out.println("Having repository: "
					+ git.getRepository().getDirectory());

			git.add().addFilepattern(".").call();
			git.commit().setMessage("Initial Commit").call();

			long endTime = System.currentTimeMillis();

			System.out.println("Repository created in "
					+ ((endTime - startTime) / 1000.) + " sec");

			Files.copy(Paths.get("Sanity.epf"), Paths.get("Sanity1.epf"),
					StandardCopyOption.REPLACE_EXISTING);
			System.out.println("file copied successfully");

			startTime = System.currentTimeMillis();
			git.add().addFilepattern(".").call();
			git.commit().setMessage("commit message").call();
			endTime = System.currentTimeMillis();
			System.out.println("Commit successful, time taken: "
					+ ((endTime - startTime) / 1000.) + " sec");

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}