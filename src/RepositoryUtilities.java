import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.*;
import com.github.difflib.*;
import com.github.difflib.patch.*;
import com.github.difflib.algorithm.*;

public class RepositoryUtilities 
{
    public String getRepoIDFromDir(String dir) throws IOException
    {
        // Get the current working directory
        String currentPath = System.getProperty("user.dir");
        currentPath = Paths.get(currentPath).normalize().toString();
        File currentDirectory = new File(currentPath);

        // Get the files in the current directory
        File[] files = currentDirectory.listFiles();

        // Search for the .coffee directory
        for (File file : files)
        {
            if (file.isDirectory() && file.getName().equals(".coffee"))
            {

                // Read the cfeinfo.txt file
                File infoFile = new File(Paths.get(file.getPath(), "cfeinfo.txt").normalize().toString());
                String content = new String(Files.readAllBytes(infoFile.toPath()));

                // Split the content into lines
                String[] lines = content.split("\n");

                // Extract the repository ID from first line
                String repositoryID = lines[0].split(",")[1];
                return repositoryID;
            }
        }
        return null;
    }

    public String getFileDiff(String cloudFileContent, String localFileContent) throws Exception
    {
        List<String> cloudLines = Arrays.asList(cloudFileContent.split("\n"));
        List<String> localLines = Arrays.asList(localFileContent.split("\n"));

        Patch<String> patch = DiffUtils.diff(cloudLines, localLines);
        List<String> patchedDiff = DiffUtils.patch(cloudLines, patch);

        // List<Delta<String>> deltas = patch.getDeltas();
        System.out.print(String.join("\n", patchedDiff));
        return String.join("\n", patchedDiff);
    }
}
