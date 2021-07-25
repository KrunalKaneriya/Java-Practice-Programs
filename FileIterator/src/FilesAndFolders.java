import java.util.*;

public class FilesAndFolders {
    private static FilesAndFolders instance = new FilesAndFolders();
    public Scanner scanner = new Scanner(System.in);
    private FilesAndFolders() {

    }

    public static FilesAndFolders getInstance() {
        return instance;
    }

    private final LinkedList<Directories> collectionList = new LinkedList<>();

    public void addDirectory(Directories directory) {
        if (directory != null) {
            collectionList.add(directory);
        } else {
            System.out.println("The Directory is Null Cannot be added.");
        }
    }

    public void addDirectory(String directoryName) {
        Directories tempDirectory = new Directories(directoryName);
        addDirectory(tempDirectory);
    }

    public void printDirectories(Directories d1) {
        if (d1 == null) {
            System.out.println("Error Getting Directory");
        }
        System.out.println("The Directory Name is : " + d1.getDirectoryName());
        d1.printFiles();
    }

    public void printDirectories() {
        if (collectionList.isEmpty()) {
            System.out.println("No Contents Are Added..");
        } else {
            for (Directories directory : collectionList) {
                System.out.println("Directory: " + directory.getDirectoryName());
            }
        }
    }

    public boolean removeDirectory(Directories directory) {
        if ((directory != null) && (collectionList.contains(directory))) {
            collectionList.remove(directory);
            System.out.println("Directory " + directory.getDirectoryName() + " removed from Collections");
            directory.getFiles().clear();
            return true;
        }
        return false;
    }

    public Directories findDirectory(String directoryName) {
        for (Directories eachDirectory : collectionList) {
            if (eachDirectory.getDirectoryName().equalsIgnoreCase(directoryName)) {
                return eachDirectory;
            }
        }
        return null;
    }


    public void start() {
        boolean quit = false;
        printMenu();
        while(!quit) {
            System.out.print("Enter A Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter The Name of Directory: ");
                        String dirName = scanner.nextLine();
                        addDirectory(dirName);
//                        scanner.nextLine();
                        break;
                    case 2:
                        if(collectionList.isEmpty()) {
                            System.out.println("Nothing is Added.");
                            break;
                        }
                        else {
                            System.out.print("Enter The Name of Directory: ");
                            String searchDirName = scanner.nextLine();
//                            scanner.nextLine();
                            Directories searchedDirectory = findDirectory(searchDirName);
                            if(searchedDirectory!=null) {
                                System.out.print("Enter The File Name: ");
                                String newFileName = scanner.nextLine();
                                searchedDirectory.addFile(newFileName);
                            }
                        }
                        break;
                    case 3:
                        if(collectionList.isEmpty()) {
                            System.out.println("Nothing is Added.");
                            break;
                        }
                        else {
                            System.out.print("Enter The Directory name to Remove: ");
                            String dirToRemove = scanner.nextLine();
                            Directories directoryToRemove = findDirectory(dirToRemove);
                            if(directoryToRemove!=null) {
                                collectionList.remove(directoryToRemove);
                            }
                        }
                        break;
                    case 4:
                        printDirectories();
                        break;
                    case 5:
                        ListIterator<Directories>directoriesListIterator = collectionList.listIterator();
                        if(collectionList.isEmpty()) {
                            System.out.println("Nothing is Added.");
                            break;
                        }
                        boolean exit = false;
                        boolean isForward = true;
                        while(!exit) {
                            printDirectoryMenu();
                            System.out.print("Enter The Choice: ");
                            int subchoice = scanner.nextInt();

                            switch (subchoice) {
                                case 1 -> {
                                    if (!isForward) {
                                        if (directoriesListIterator.hasNext()) {
                                            directoriesListIterator.next();
                                            isForward = true;
                                        }
                                    }
                                    if (directoriesListIterator.hasNext()) {
                                        Directories tempDirectory = directoriesListIterator.next();
                                        System.out.println("Directory Name: " + tempDirectory.getDirectoryName());
                                        tempDirectory.printFiles();
                                    } else {
                                        System.out.println("The List Has Ended..");
                                        isForward = false;
                                    }
                                }
                                case 2 -> {
                                    if (isForward) {
                                        if (directoriesListIterator.hasPrevious()) {
                                            directoriesListIterator.previous();
                                            isForward = false;
                                        }
                                    }
                                    if (directoriesListIterator.hasPrevious()) {
                                        Directories tempDirectory = directoriesListIterator.previous();
                                        System.out.println("Directory Name: " + tempDirectory.getDirectoryName());
                                        tempDirectory.printFiles();
                                    } else {
                                        System.out.println("The List is At Starting Point..");
                                        isForward = true;
                                    }
                                }
                                case 3 -> printDirectoryMenu();
                                case 4 -> {
                                    scanner.nextLine();
                                    Directories tempDirectory = directoriesListIterator.next();
                                    System.out.println("Directory Name: " + tempDirectory.getDirectoryName());
                                    tempDirectory.printFiles();
                                    System.out.print("Enter The File Name: ");
                                    String newName = scanner.nextLine();
                                    tempDirectory.renameFile(newName);
                                }
                                case 5 ->  {
                                    exit = true;
                                    start();
                                }
                                default -> {
                                    System.out.println("Enter The Choice Again..");
                                }
                            }
                        }
                    case 6:
                        quit = true;
                        break;
                    default:
                        System.out.println("Enter The Choice Again..");
                }
        }
    }

    private void printMenu() {
        System.out.println("1. To Add A Directory.");
        System.out.println("2. To Add A File In Directory.");
        System.out.println("3. To Remove The Directory From Collections.");
        System.out.println("4. To Print The Directories Available in Collections.");
        System.out.println("5. To Iterate Over Directories In Collections.");
        System.out.println("6. To Quit");
    }
    private void printDirectoryMenu() {
        System.out.println("1.To Go To Next Directory");
        System.out.println("2.To Go To Previous Directory");
        System.out.println("3.Print The Menu Again");
        System.out.println("4.Rename File");
        System.out.println("5.Exit");
    }

}

