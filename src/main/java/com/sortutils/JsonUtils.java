package com.sortutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.lang.reflect.Type;
//com.google.gson.reflect.TypeToken

public class JsonUtils {
  
  private Gson gson;
  
  public JsonUtils() {
    this.gson = new GsonBuilder().setPrettyPrinting().create();
  }


  public <T> String toJson(T prop) {
    return gson.toJson(prop);
}
  
  
  public <T> T fromJson(String jsonText, Class<T> t){
    return  gson.fromJson(jsonText, t);
 }
  
  
  public <T> T fromJson(Reader reader, Class<T> t){
    return  gson.fromJson(reader, t);
 }
  
  
  public <T> T fromJson(Reader reader, Type t){
    return  gson.fromJson(reader, t);
 }

  
  

}
