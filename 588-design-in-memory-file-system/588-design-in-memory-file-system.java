class FileSystem {
        class File {
            String name;
            boolean isFolder = false;
            Set<File> directories;
            StringBuilder content;

            public File(String name, boolean isFolder){
                this.name = name;
                this.isFolder = isFolder;
                directories = new HashSet<>();
                content = new StringBuilder();
            }

            public void addFolder(File directory){
                directories.add(directory);
            }

            public boolean isFolder(){
                return isFolder;
            }

            public void addContentToFile(String newContent){
                content.append(newContent);
            }

            public String getContent(){
                return content.toString();
            }

            public Set<File> listFiles(){
                return directories;
            }

            public String getName(){
                return name;
            }

            public void addFile(File file){
                directories.add(file);
            }
        }

        File root;
        public FileSystem() {
            root = new File("/", true);
        }

        /*Ex: /a/b/c */
        public List<String> ls(String path) {
            List<String> res = new ArrayList<>();
            if(path.equals(root.getName())){
                for(File file : root.listFiles()){
                    res.add(file.getName());
                }
                Collections.sort(res);
                return res;
            }
            String[] arr = path.split("/");
            String[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
            File ans = getDirectory(newArr, 0, root);
            if(!ans.isFolder()){
                res.add(ans.getName());
            }else{
                for(File file : ans.listFiles()){
                    res.add(file.getName());
                }
            }
            Collections.sort(res);
            return res;
        }

        public File getDirectory(String[] files, int idx, File root){
            if(idx == files.length){
                return root;
            }
            String curr = files[idx];
            File folder = null;
            File file = null;
            for(File subFolder : root.listFiles()){
                if(subFolder.getName().equals(curr) && subFolder.isFolder()){
                    folder = subFolder;
                }else if(subFolder.getName().equals(curr) && !subFolder.isFolder()){
                    file = subFolder;
                }
            }
            if(file != null){
                return file;
            }
            return getDirectory(files, idx + 1, folder);
        }
        /* Ex : /a/b/c */
        public void mkdir(String path) {
            String[] arr = path.split("/");
            String[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
            makeDirHelper(newArr, 0, root);
        }

        public void makeDirHelper(String[] files, int idx, File currFolder){
            if(idx == files.length){
                return;
            }
            String currFile = files[idx];
            File newFolder = null;
            for(File curr : currFolder.listFiles()){
                if(curr.getName().equals(currFile) && curr.isFolder()){
                    newFolder = curr;
                    break;
                }
            }
            if(newFolder == null){
                newFolder = new File(currFile, true);
            }
            currFolder.addFolder(newFolder);
            makeDirHelper(files, idx + 1, newFolder);
        }

        public void addContentToFile(String filePath, String content) {
            String[] arr = filePath.split("/");
            String[] newArr = Arrays.copyOfRange(arr, 1, arr.length - 1);
            File curr = getDirectory(newArr, 0, root);
            String fileToAddContent = arr[arr.length -1];

            boolean found = false;
            for(File file : curr.listFiles()){
                if(file.getName().equals(fileToAddContent)){
                    file.addContentToFile(content);
                    curr.addFile(file);
                    found = true;
                    break;
                }
            }
            if(!found){
                File newFile = new File(fileToAddContent, false);
                newFile.addContentToFile(content);
                curr.addFile(newFile);
            }
        }

        /* Ex : /a/b/c/d */
        public String readContentFromFile(String filePath) {
            String[] arr = filePath.split("/");
            String[] newArr = Arrays.copyOfRange(arr, 1, arr.length - 1);
            File curr = getDirectory(newArr, 0, root);
            String fileToReadContent = arr[arr.length - 1];
            String content = "";

            for (File file : curr.listFiles()) {
                if (file.getName().equals(fileToReadContent)) {
                    content = file.getContent();
                    break;
                }
            }
            return content;
        }
    }