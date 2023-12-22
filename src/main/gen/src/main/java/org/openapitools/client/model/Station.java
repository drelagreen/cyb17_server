/*
 * Railway Station API
 * API for managing railway stations, parks, ways, locomotives, and wagons.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * Station
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-12-22T22:15:41.762441+03:00[Europe/Moscow]")
public class Station {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_IS_LOGIN_STATION = "isLoginStation";
  @SerializedName(SERIALIZED_NAME_IS_LOGIN_STATION)
  private Boolean isLoginStation;

  public static final String SERIALIZED_NAME_PARKS_COUNT = "parksCount";
  @SerializedName(SERIALIZED_NAME_PARKS_COUNT)
  private Integer parksCount;

  public static final String SERIALIZED_NAME_PARKS_IDS = "parksIds";
  @SerializedName(SERIALIZED_NAME_PARKS_IDS)
  private List<Integer> parksIds = null;

  public Station() {
  }

  public Station id(Integer id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public Station title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public Station isLoginStation(Boolean isLoginStation) {
    
    this.isLoginStation = isLoginStation;
    return this;
  }

   /**
   * Get isLoginStation
   * @return isLoginStation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsLoginStation() {
    return isLoginStation;
  }


  public void setIsLoginStation(Boolean isLoginStation) {
    this.isLoginStation = isLoginStation;
  }


  public Station parksCount(Integer parksCount) {
    
    this.parksCount = parksCount;
    return this;
  }

   /**
   * Get parksCount
   * @return parksCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getParksCount() {
    return parksCount;
  }


  public void setParksCount(Integer parksCount) {
    this.parksCount = parksCount;
  }


  public Station parksIds(List<Integer> parksIds) {
    
    this.parksIds = parksIds;
    return this;
  }

  public Station addParksIdsItem(Integer parksIdsItem) {
    if (this.parksIds == null) {
      this.parksIds = new ArrayList<>();
    }
    this.parksIds.add(parksIdsItem);
    return this;
  }

   /**
   * Get parksIds
   * @return parksIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Integer> getParksIds() {
    return parksIds;
  }


  public void setParksIds(List<Integer> parksIds) {
    this.parksIds = parksIds;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Station station = (Station) o;
    return Objects.equals(this.id, station.id) &&
        Objects.equals(this.title, station.title) &&
        Objects.equals(this.isLoginStation, station.isLoginStation) &&
        Objects.equals(this.parksCount, station.parksCount) &&
        Objects.equals(this.parksIds, station.parksIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, isLoginStation, parksCount, parksIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Station {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    isLoginStation: ").append(toIndentedString(isLoginStation)).append("\n");
    sb.append("    parksCount: ").append(toIndentedString(parksCount)).append("\n");
    sb.append("    parksIds: ").append(toIndentedString(parksIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("id");
    openapiFields.add("title");
    openapiFields.add("isLoginStation");
    openapiFields.add("parksCount");
    openapiFields.add("parksIds");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Station
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (Station.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in Station is not found in the empty JSON string", Station.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Station.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Station` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull()) && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      // ensure the json data is an array
      if ((jsonObj.get("parksIds") != null && !jsonObj.get("parksIds").isJsonNull()) && !jsonObj.get("parksIds").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `parksIds` to be an array in the JSON string but got `%s`", jsonObj.get("parksIds").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Station.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Station' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Station> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Station.class));

       return (TypeAdapter<T>) new TypeAdapter<Station>() {
           @Override
           public void write(JsonWriter out, Station value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Station read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Station given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Station
  * @throws IOException if the JSON string is invalid with respect to Station
  */
  public static Station fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Station.class);
  }

 /**
  * Convert an instance of Station to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

