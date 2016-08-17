package com.journaldev.springhibernate.service;
import javax.faces.bean.ManagedBean;



@ManagedBean
public class EditorView {
    
   private String text;

   public String getText() {
       return text;
   }

   public void setText(String text) {
       this.text = text;
   }
}