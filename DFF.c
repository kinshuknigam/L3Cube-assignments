/*Program no -- 05 (Duplicate file finder)
  Created By:   Ghatule Sumit
  Date: 		    07 July, 2015.
  Compile: 			gcc DFF.c -o dff.exe
  Run: 				  ./dff.exe  parent_dir  filename
*/

#include<stdio.h>
#include<dirent.h>
#include<sys/stat.h>
#include<errno.h>
#include<string.h>
#include<stdlib.h>
#include<fcntl.h>

#define false 0
#define true  1

int duplicateCount = 0;

int FindDuplicates(char* path, char* fileName);
int CompareFiles(char* originalFile, char* currFile);

int main(int argc, char *argv[])
{
	int ret;
        char filename[100];
         FILE *fp;
        //Two additional arguments are expected: Parent dir, file to find duplicates of...

	if (argc!=3)					
	{
		printf("Usage: %s 'Base Directory' 'File Name'\n", argv[0]);
		return -1;
	}
	else	
	{
    
        FILE *file = fopen( argv[2], "r" );

        if ( file == 0 )
        {
            printf( "Could not open file\n" );
        }
        else 
        {
            int x;
        while  ( ( x = fgetc( file ) ) != EOF )
            {
                printf( "%c", x );
            }
            fclose( file );
        }
        }
	
        //argv[1] = base dir, argv[2] = file to find duplicates of; e.g argv[1] = /home,

	FindDuplicates(argv[1], argv[2]);		
	printf("\n\nFound %d duplicate(s)\n", duplicateCount); 
	
 	printf("Enter the name of file path you wish to remove=\n");
   	gets(filename);

  	 fp = fopen(filename, "w");

  	 fclose(fp);
   
   	ret = remove(filename);

  	 if(ret == 0) 
  	 {
   	   printf("File deleted successfully");
  	 }
 	 else 
   	 {
      	  printf("Error: unable to delete the file");
  	 }
   
         return(0);
}


int FindDuplicates(char* path, char* fileName)
{
	DIR *dir;
	struct dirent *dp;
	struct dirent *result;
	struct stat statp;

	char absoluteFilePath[255];

	if ((dir = opendir(path))== NULL)
	{
		perror("Failed to open directory");
		return -1;
	}


	while ((dp =readdir(dir)) != NULL)
	{	
		//readdir returns . and .. which we should ignore...
		if (strcmp(dp->d_name, ".") && strcmp(dp->d_name,".."))	
		{
		    //find file full path, relative to base path. e.g, a /home/file.txt...

                        //copy path to absoluteFilePath...
			strcpy(absoluteFilePath, path);				

                        //append / at end...
			strcat(absoluteFilePath, "/");    	 		

                        //append filename to path...
 			strcat(absoluteFilePath, dp->d_name); 			


			//check if the current file is actually file or dir...
			stat(absoluteFilePath, &statp);

			if (S_ISDIR(statp.st_mode))		//is a directory...
			{   
                                
				FindDuplicates(absoluteFilePath, fileName);		
			}
			else if (S_ISREG(statp.st_mode))	//is a file...
			{
				//check for duplicates here...
				//compare current file with the file specified by user...
            
				if (strcmp(fileName, absoluteFilePath))	   
				{
                                        if (CompareFiles(fileName, absoluteFilePath))
					{    
                                                //yes, duplicate; print it...
						printf("%s\n", absoluteFilePath);
						duplicateCount++;
					}
				}

			}		//end else if (S_ISREG(statp.st_mode))...

		}	    //if (strcmp(dp->d_name, ".") && strcmp(dp->d_name,".."))...
	}	    //end while...

	closedir(dir);
	return 0;

}


int CompareFiles(char* originalFile, char* currFile)
{
	//two step comparison: (1) first check size; if not same, return false.
        //If equal, (2) compare file content. If equal, return true, false otherwise...

	struct stat statOriginal, statCurr;
	stat(originalFile, &statOriginal);
	stat(currFile, &statCurr);

	//Step 1...
	if ((int) statOriginal.st_size != (int) statCurr.st_size)  //size not same...
		return false;

	//Step 2...
	//size matches, files can be same; confirm it by matching both file contents...

	int fdOriginal  = open(originalFile, O_RDONLY);
	int fdCurr	= open(currFile, O_RDONLY);

	if (fdOriginal == -1 || fdCurr == -1)
		return false;		//error occurred, not sure if file is duplicate...


	//read file in small chunks and compare...

	int chunkSize = 1024, bytesRead;
	char *bufferOriginal  = (char*) malloc(chunkSize * sizeof(char));
	char *bufferCurr      = (char*) malloc(chunkSize * sizeof(char));

	while (true)
	{
		//read file in chunk...
		bytesRead = read(fdOriginal, bufferOriginal, chunkSize);
		if (bytesRead <= 0)
			break;		//end of file...

		bytesRead = read(fdCurr, bufferCurr, bytesRead);

		//compare buffer...
		if (strcmp(bufferOriginal, bufferCurr))	    //if content not matching...
			return false;			
	}

	return true;
}


/*                              ----OUTPUT-----

[root@localhost ~]# gcc DFF.c -o dff.exe

[root@localhost ~]# ./dff.exe  /root  /root/abc.java
import java.io.*;
class abc
{ 
	public static void main(String args[])
	{
		System.out.println("Sumit");
	}	
	

}
/root/Data/Sumit/abc.java
/root/Data/abc.java


Found 2 duplicate(s)

Enter the name of file path you wish to remove=
/root/Data/abc.java
File deleted successfully
[root@localhost ~]#
*/
