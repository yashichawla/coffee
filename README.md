# Coffee

A version control system built using Java and DropBox API.

Coffee supports most major version control features such as `add`, `commit`, `pull`, `push`, `status`, `clone` to name a few. The CLI also features prominent CLI utility tools to help out such as `clear`, `cd`, `mkdir`, `rmdir`, `nano`, `ls` and `cat`.

# How to use Coffee

## Command Line Interface

To run Coffee on command-line, run `./compile_and_run.sh`

If you would like to run with the debugger, use `./compile_and_run.sh --debug`

```bash
Welcome to Coffee!
>>>
```

### User Level Functions

#### Create User

You can create users using `cfe user create`. This will create user specific directories on DropBox as well.

```bash
>>> cfe user create
Enter username: yashichawla
Enter email: yashi@gmail.com
Enter password:
Creating ID: USER000003
New user successfully created.
```

#### Login as User

You can create users using `cfe user login`
```bash
>>> cfe user login
Enter username: yashichawla
Enter password: 
Welcome back, yashichawla
```

#### Logout

You can logout using `cfe user logout`
```bash
>>> cfe user logout
You have logged out.
```

### Repository Level Functions

To access repository functions, you need to be inside a directory with a `.cfe` subfolder. The `.cfe` subfolder handles all commit history, and stores the diffs in tracked files across commits.

You can either navigate to a directory with `cd` or clone or create a repository as required.

#### Creating Repositories

You can create a repository using `cfe init [REPOSITORY NAME]`. This will create a local directory with a `.cfe` subfolder to handle commit history. The repository will also gets created on DropBox.

```bash
>>> cfe init myfirstrepo
Enter repository description? [y/n]: y
Enter repository description (under 150 chars): this is myfirstrepo
Enter repository visibility [public/private]: public
New repository successfully created.
Uploading .cfe/.bean
```

#### Cloning a Repository
To clone a repository, it either needs to be public or you need to have collaborator access to it. Clone a repository using `cfe clone [USERNAME]/[REPOSITORY NAME]`

```bash
>>> cfe clone yashichawla/helloworld
Cloning repository helloworld...
Archive:  helloworld.zip
   creating: helloworld/
   creating: helloworld/.cfe/
 extracting: helloworld/.cfe/.bean
```

#### Tracking Files

You can track files using the `cfe add [.|FILEPATH FILEPATH ...]`. Using a `.` will track all files inside the directory recursively. 

```bash
>>> cfe add .
File ./helloworld.txt successfully tracked.
File ./.cfe/.bean successfully tracked.
```

#### Making Commits

You can create commits using `cfe commit [COMMIT MESSAGE]`. Once committed, diff files are generated and commit history is created in `.cfe`.

```bash
>>> cfe commit add helloworld.txt           
added changes: ./helloworld.txt
1 files changed: 1 addtions(+) 0 deletions(-)
```

#### Fetching and Displaying Status

You can fetch the commit history on the remote and compare it with your local working copy. To perform a check, run `cfe status`

```bash
>>> cfe status
modified: ./.cfe/.bean
modified: ./helloworld.txt
```

#### Pushing Changes

You can push your changes to the remote using `cfe push`. This will update the repository directory on DropBox with the files in your local repository directory.

```bash
>>> cfe push
Uploading helloworld.txt
Uploading .cfe/.bean
Uploading .cfe/COMMIT000005--2021-04-11-16:42:57/FILE000008.txt
```

#### Pulling Changes from Remote

You can pull changes from remote using `cfe pull`. Internally, a `cfe status` is also performed to check for diffs in each file.

```bash
>>> cfe pull
Pulling changes...
Archive:  myfirstrepo.zip
 extracting: myfirstrepo/hi.txt      
 extracting: myfirstrepo/helloworld.txt  
 extracting: myfirstrepo/.cfe/.bean  
   creating: myfirstrepo/.cfe/COMMIT000006--2021-04-11-18:49:18/
 extracting: myfirstrepo/.cfe/COMMIT000005--2021-04-11-16:42:57/FILE000008.txt  
 extracting: myfirstrepo/.cfe/COMMIT000006--2021-04-11-18:49:18/FILE000010.txt 
```

#### Adding Collaborators
To add a collaborator, you need to be the owner of the repository. Add a collaborator using `cfe repo add collab [USERNAME]`

```bash
>>> cfe repo add collab vibhamasti
User vibhamasti successfully added as collaborator.
```

### Command Line Tools
Coffee also features prominent command line utilities to allow users to quickly made file edits as well as move files and folders without leaving the application.

1. `cd [PATH]`
2. `ls [OPTIONAL=DIRECTORY PATH]`
3. `cat [FILE PATH]`
4. `mkdir [DIRECTORY PATH]`
5. `rmdir [DIRECTORY PATH]`
6. `clear` or `cls`

### Help
Coffee also features a convenient `help` command to assist you in times of need.

```bash
>>> help
Coffee

Coffee is a version control system built using Java and DropBox API

1. User Commands

cfe create user -- Create an account
cfe user login username password -- Login to existing account

2. Repository Commands

cfe init repository_name -- Create a new repository
...
```

### Coffee

If you would like to see a cute Coffee beans, just type `coffee` 

```bash
>>> coffee                                                        
                                                    %%% %%%%#           
                                                 %%%%%%(%%%%%%%         
                                              (%%%%%%% %%%%%%%%%        
    %%%%%%%%%%%.                             %%%%%%%%% %%%%%%%%%#       
   %%%%%%%%%%%%%%%%%                        %%%%%%%%%  %%%%%%%%%%       
 %% .%%%%%%%%%%%%%%%%%%                    %%%%%%%%%   %%%%%%%%%%       
%%%%%% %%%%%%%%%%%%%%%%%%                 %%%%%%%%%*   %%%%%%%%%%       
%%%%%%%%  %%%%%%%%%%%%%%%%%               %%%%%%%%%    %%%%%%%%%        
%%%%%%%%%%    %%%%%%%%%%%%%%              %%%%%%%%%   %%%%%%%%%         
 %%%%%%%%%%.     %%%%%%%%%%%%             %%%%%%%%%  %%%%%%%%%          
 *%%%%%%%%%%%      %%%%%%%%%%%            #%%%%%%%% #%%%%%%%            
  *%%%%%%%%%%%%#     %%%%%%%%%%            (%%%%%%% %%%%%%(             
    %%%%%%%%%%%%%%%   *%%%%%%%%              %%%%%% %%%%                
     %%%%%%%%%%%%%%%%%  %%%%%%%(                                        
       %%%%%%%%%%%%%%%%%% *%%%%                                         
          %%%%%%%%%%%%%%%%%%                                            
             %%%%%%%%%%%%%%%#                                           
                  .%%%%%%%                                              
                                              %%%%%% %%%                
                                           %%%%%%%% %%%%%               
                                         %%%%%%%%  %%%%%%%              
                                       %%%%%%%%   %%%%%%%               
                                      %%%%%%%%   %%%%%%%%               
                                     (%%%%%%%  %%%%%%%%#                
                                     #%%%%%% *%%%%%%%%                  
                                      %%%%% %%%%%%%                     
                                       #%% %%%%%  
```                           
                      
                                                                  
# Contributing to Coffee

Contributions to Coffee are welcome, in the form of bug fixes as well as feature enhancements. We look forward to adding more features to the CLI, such as `forks` and `branches`.

# Acknowledgements

This project was made as a part of the Object Oriented Analysis and Design Course (UE19CS353) at PES University. 

[Yashi Chawla](https://github.com/Yashi-Chawla)<br>
[Vibha Masti](https://github.com/vibhamasti)<br>
[Vishruth Veerendranath](https://github.com/vishruth-v)