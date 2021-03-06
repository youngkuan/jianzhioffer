package com.elearning.chapter2.interviewquestion4_stringreplaceblank;

public class StringReplaceBlankImpl {

    /**
     * 将字符数组中的空格全部替换成%20
     * @param chars
     * @return
     */
    private static char[] replaceBlank(char[] chars){
        int blankNumber = 0;
        //统计空格总数
        for(char c:chars){
            if(c==' '){
                blankNumber ++;
            }
        }
        //新数组长度
        int newLength = chars.length + 2*blankNumber;
        char[] extendedChars = new char[newLength];
        //旧指针
        int oldIndex = chars.length - 1;
        //新指针
        int newIndex = newLength - 1;
        for(int i=chars.length-1; i>=0;i--){
            if(chars[i]==' '){
                extendedChars[newIndex-2] = '%';
                extendedChars[newIndex-1] = '2';
                extendedChars[newIndex] = '0';
                newIndex = newIndex - 3;
                oldIndex --;
            }
            else {
                extendedChars[newIndex] = chars[oldIndex];
                newIndex --;
                oldIndex --;
            }
        }
        return extendedChars;
    }
    public static String replaceSpace(StringBuffer str) {
        int size = str.length();
        String replacedStr = new String();
        for(int i=0;i<size;i++){
            if(str.charAt(i)==' '){
                replacedStr += "%20";
            }
            else {
                replacedStr += str.charAt(i);
            }
        }
        return replacedStr;
    }

    public static void main(String[] args) {
        char[] chars = {'h','k','l',' ','m','n'};
        System.out.println(replaceBlank(chars));
        StringBuffer str = new StringBuffer("hello world");
        System.out.println(replaceSpace(str));
    }

}
