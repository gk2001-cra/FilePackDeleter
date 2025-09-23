import java.util.*;
import java.io.*;


/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name 	:       PackDeleter
//  Description :       Provides functionality to delete files of a specific 
//                      type/extension from a given directory.
//  Author 		:       Gaurav Subhash Kumbhar
//
/////////////////////////////////////////////////////////////////////////////////

class PackDeleter
{
	
	//////////////////////////////////////////////////////////////////////////////
	//
	//  Function Name :     getDescription
	//  Description   :     Accepts a directory name, asks the user for a file type, 
	//                      and deletes all files of that type from the directory.
	//  Author        :     Gaurav Subhash Kumbhar
	//
	//////////////////////////////////////////////////////////////////////////////
	
	public void Deleter(String DirName)
	{
		Scanner sobj = new Scanner(System.in);
		
		// File object for directory
		File fobj = new File(DirName);
		
		// Check if directory exists and is actually a directory
		if((fobj.exists()) && (fobj.isDirectory()))
		{
			System.out.println("Directory is present....");
			
			// Get list of files in the directory
			File Arr[] = fobj.listFiles();
			
			System.out.println("File Present in directory is : "+Arr.length);
		}
		else
		{
			System.out.println("No Such Directory....");
			return;
		}
	
		System.out.println("Enter type of files you want to delete : ");
		String FileType = sobj.nextLine();
		
		// File object for filtering
		File directory = new File(DirName); 
		
		// Filter for matching only files ending with given extensions
        FilenameFilter Filter = new FilenameFilter() 
		{
            public boolean accept(File dir, String name) 
			{
                return name.endsWith(FileType);
            }
        };
		
		// Get files that match the filter 
        File[] DotFiles = directory.listFiles(Filter);
		
		// Get list of files in the directory	
		File[] Brr = fobj.listFiles();
		
		// If nno files available in directory
		if(Brr.length == 0)
		{
			System.out.println("No "+FileType+" file in the Directory are present...");
		}
		else
		{
			// If matching files exists delete them
			if (DotFiles != null) 
			{
				for (File file : DotFiles) 
				{
					// Delete files
					file.delete();
				}
			}
			
			System.out.println("Files Deleted Sucessfully....");
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------Thank you for using app-------------------");
		System.out.println("--------------------------------------------------------------");
	
	}
}

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name 	:       PackDeleter
//  Description :       Main class Takes user input for directory name and 
//						calls PackDeleter to delete files of the specified type.
//  Author 		:       Gaurav Subhash Kumbhar
//
/////////////////////////////////////////////////////////////////////////////////

class FilePackDeleter
{
	
	//////////////////////////////////////////////////////////////////////////////
	//
	//  Function Name :     getDescription
	//  Description   :   	Entry point function for the application which accepts 
	//						Directory name.
	//  Author        :     Gaurav Subhash Kumbhar
	//
	//////////////////////////////////////////////////////////////////////////////
	
	public static void main(String A[])
	{
		System.out.println("--------------------------------------------------------------");
		System.out.println("----------------Welcome To File Pack Deleter------------------");
		System.out.println("--------------------------------------------------------------");
		
		Scanner sobj = new Scanner(System.in);		// Scanner object
		
		System.out.println("Enter name of directory : ");
		String DirName = sobj.nextLine();
		
		PackDeleter pobj = new PackDeleter();
		
		pobj.Deleter(DirName);
	}	
}