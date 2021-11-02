package injection;

import injection.exceptions.InvalidDirectoryException;


import java.io.File;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClassScanner {
    private final String CLASS_EXTENSION = ".class";
    private final Set<Class<?>> foundClasses;

    public ClassScanner(){
        this.foundClasses = new HashSet<>();
    }

    public Set<Class<?>> findClasses(Class<?> startClass){
        String directory = getDirectory(startClass);
        File file = new File(directory);

        if(!file.isDirectory()){
            throw new InvalidDirectoryException("Invalid directory: " + directory);
        }

        try{
            for(File innerFile : Objects.requireNonNull(file.listFiles())){
                scanDirectory(innerFile, "");
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e.getMessage(), e);
        }

        return foundClasses;
    }

    private String getDirectory(Class<?> someClass){
        return someClass.getProtectionDomain().getCodeSource().getLocation().getFile();
    }

    private void scanDirectory(File file, String packageName) throws ClassNotFoundException {

        if(file.isDirectory()){
            packageName += file.getName() + ".";
            for(File innerFile : Objects.requireNonNull(file.listFiles())){
                scanDirectory(innerFile, packageName);
            }
        }

        if(!file.getName().endsWith(CLASS_EXTENSION)){
            return;
        }

        String className = packageName + file.getName().replace(CLASS_EXTENSION, "");

        foundClasses.add(Class.forName(className));
    }


}
