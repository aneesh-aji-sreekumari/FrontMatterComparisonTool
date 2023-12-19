package com.officetools.frontmattercomparisontool.models;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TocSearchItem {
   private String pageblock;
   private String taskTitle;
   private String subtaskTitle;
   private String taskNumber;
   private String subtaskNumber;

   private int getCharcterIndex(String str, char ch, int i, int N){
       for(int j=i; j<N; j++){
           if(str.charAt(j) == ch)
               return j;
       }
       return 0;
   }
   public TocSearchItem extractTocSearchItems(String str){
       TocSearchItem tocSearchItem = new TocSearchItem();
       int N = str.length();
       int i=0;
       while(i<N){
           if(str.charAt(i) == '{'){
               int j = getCharcterIndex(str, '}', i+1, N);
               tocSearchItem.setPageblock(str.substring(i+1, j));
               i = j+1;
           }
           else if(str.charAt(i) == '<'){
               int j = getCharcterIndex(str, '>', i+1, N);
               tocSearchItem.setPageblock(str.substring(i+1, j));
               i = j+1;
           }
           else if(str.charAt(i) == '('){
               int j = getCharcterIndex(str, ')', i+1, N);
               tocSearchItem.setPageblock(str.substring(i+1, j));
               i = j+1;
           }
           else if(str.charAt(i) == '|'){
               int j = getCharcterIndex(str, '|', i+1, N);
               tocSearchItem.setPageblock(str.substring(i+1, j));
               i = j+1;
           }
           else if(str.charAt(i) == '['){
               int j = getCharcterIndex(str, ']', i+1, N);
               tocSearchItem.setPageblock(str.substring(i+1, j));
               i = j+1;
           }
           else
               i++;
       }
       return tocSearchItem;
   }
}
