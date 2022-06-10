class TextEditor {
    StringBuilder out = new StringBuilder();
        int cursorPos = 0;
        public TextEditor() {

        }

        public void addText(String text) {
            if(out.length() == 0){
                out.append(text);
                cursorPos = text.length();
            }else{
                out.insert(cursorPos, text);
                cursorPos += text.length();
            }
        }

        public int deleteText(int k) {
            int end = cursorPos;
            int start = cursorPos - Math.min(cursorPos, k);
            out.delete(start, end);
            cursorPos -= (end - start);
            return end - start;
        }

        public String cursorLeft(int k) {
            cursorPos = Math.max(0, cursorPos - k);
            int start = Math.min(10, cursorPos);
            return out.substring(cursorPos - start, cursorPos);
        }

        public String cursorRight(int k) {
            cursorPos = Math.min(out.length(), cursorPos + k);
            int start = Math.min(10, cursorPos);
            return out.substring(cursorPos - start, cursorPos);
        }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */