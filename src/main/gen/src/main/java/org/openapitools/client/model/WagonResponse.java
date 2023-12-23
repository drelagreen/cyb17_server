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
import java.math.BigDecimal;
import org.openapitools.client.model.Cargo;

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
 * WagonResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-12-23T05:23:19.175324+03:00[Europe/Moscow]")
public class WagonResponse {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_INVENTORY_NUMBER = "inventoryNumber";
  @SerializedName(SERIALIZED_NAME_INVENTORY_NUMBER)
  private String inventoryNumber;

  public static final String SERIALIZED_NAME_POSITION = "position";
  @SerializedName(SERIALIZED_NAME_POSITION)
  private Integer position;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_IS_SICK = "isSick";
  @SerializedName(SERIALIZED_NAME_IS_SICK)
  private Boolean isSick;

  public static final String SERIALIZED_NAME_CARGO = "cargo";
  @SerializedName(SERIALIZED_NAME_CARGO)
  private Cargo cargo;

  public static final String SERIALIZED_NAME_OPERATION_STATE = "operationState";
  @SerializedName(SERIALIZED_NAME_OPERATION_STATE)
  private String operationState;

  public static final String SERIALIZED_NAME_IDLE_DAYS_LENGTH = "idleDaysLength";
  @SerializedName(SERIALIZED_NAME_IDLE_DAYS_LENGTH)
  private Integer idleDaysLength;

  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private String owner;

  public static final String SERIALIZED_NAME_IS_WITH_HATCH = "isWithHatch";
  @SerializedName(SERIALIZED_NAME_IS_WITH_HATCH)
  private Boolean isWithHatch;

  public static final String SERIALIZED_NAME_LOAD_CAPACITY = "loadCapacity";
  @SerializedName(SERIALIZED_NAME_LOAD_CAPACITY)
  private BigDecimal loadCapacity;

  public static final String SERIALIZED_NAME_DAYS_TO_REPAIR = "daysToRepair";
  @SerializedName(SERIALIZED_NAME_DAYS_TO_REPAIR)
  private Integer daysToRepair;

  public static final String SERIALIZED_NAME_KILOMETERS_LEFT = "kilometersLeft";
  @SerializedName(SERIALIZED_NAME_KILOMETERS_LEFT)
  private Integer kilometersLeft;

  public static final String SERIALIZED_NAME_IS_DIRTY = "isDirty";
  @SerializedName(SERIALIZED_NAME_IS_DIRTY)
  private Boolean isDirty;

  public static final String SERIALIZED_NAME_NOTE1 = "note1";
  @SerializedName(SERIALIZED_NAME_NOTE1)
  private String note1;

  public static final String SERIALIZED_NAME_NOTE2 = "note2";
  @SerializedName(SERIALIZED_NAME_NOTE2)
  private String note2;

  public static final String SERIALIZED_NAME_PARK_ID = "parkId";
  @SerializedName(SERIALIZED_NAME_PARK_ID)
  private Integer parkId;

  public static final String SERIALIZED_NAME_STATION_ID = "stationId";
  @SerializedName(SERIALIZED_NAME_STATION_ID)
  private Integer stationId;

  public static final String SERIALIZED_NAME_WAY_ID = "wayId";
  @SerializedName(SERIALIZED_NAME_WAY_ID)
  private Integer wayId;

  public WagonResponse() {
  }

  public WagonResponse id(Integer id) {
    
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


  public WagonResponse inventoryNumber(String inventoryNumber) {
    
    this.inventoryNumber = inventoryNumber;
    return this;
  }

   /**
   * Get inventoryNumber
   * @return inventoryNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getInventoryNumber() {
    return inventoryNumber;
  }


  public void setInventoryNumber(String inventoryNumber) {
    this.inventoryNumber = inventoryNumber;
  }


  public WagonResponse position(Integer position) {
    
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getPosition() {
    return position;
  }


  public void setPosition(Integer position) {
    this.position = position;
  }


  public WagonResponse type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  public WagonResponse isSick(Boolean isSick) {
    
    this.isSick = isSick;
    return this;
  }

   /**
   * Get isSick
   * @return isSick
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsSick() {
    return isSick;
  }


  public void setIsSick(Boolean isSick) {
    this.isSick = isSick;
  }


  public WagonResponse cargo(Cargo cargo) {
    
    this.cargo = cargo;
    return this;
  }

   /**
   * Get cargo
   * @return cargo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Cargo getCargo() {
    return cargo;
  }


  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }


  public WagonResponse operationState(String operationState) {
    
    this.operationState = operationState;
    return this;
  }

   /**
   * Get operationState
   * @return operationState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOperationState() {
    return operationState;
  }


  public void setOperationState(String operationState) {
    this.operationState = operationState;
  }


  public WagonResponse idleDaysLength(Integer idleDaysLength) {
    
    this.idleDaysLength = idleDaysLength;
    return this;
  }

   /**
   * Get idleDaysLength
   * @return idleDaysLength
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getIdleDaysLength() {
    return idleDaysLength;
  }


  public void setIdleDaysLength(Integer idleDaysLength) {
    this.idleDaysLength = idleDaysLength;
  }


  public WagonResponse owner(String owner) {
    
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOwner() {
    return owner;
  }


  public void setOwner(String owner) {
    this.owner = owner;
  }


  public WagonResponse isWithHatch(Boolean isWithHatch) {
    
    this.isWithHatch = isWithHatch;
    return this;
  }

   /**
   * Get isWithHatch
   * @return isWithHatch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsWithHatch() {
    return isWithHatch;
  }


  public void setIsWithHatch(Boolean isWithHatch) {
    this.isWithHatch = isWithHatch;
  }


  public WagonResponse loadCapacity(BigDecimal loadCapacity) {
    
    this.loadCapacity = loadCapacity;
    return this;
  }

   /**
   * Get loadCapacity
   * @return loadCapacity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BigDecimal getLoadCapacity() {
    return loadCapacity;
  }


  public void setLoadCapacity(BigDecimal loadCapacity) {
    this.loadCapacity = loadCapacity;
  }


  public WagonResponse daysToRepair(Integer daysToRepair) {
    
    this.daysToRepair = daysToRepair;
    return this;
  }

   /**
   * Get daysToRepair
   * @return daysToRepair
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getDaysToRepair() {
    return daysToRepair;
  }


  public void setDaysToRepair(Integer daysToRepair) {
    this.daysToRepair = daysToRepair;
  }


  public WagonResponse kilometersLeft(Integer kilometersLeft) {
    
    this.kilometersLeft = kilometersLeft;
    return this;
  }

   /**
   * Get kilometersLeft
   * @return kilometersLeft
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getKilometersLeft() {
    return kilometersLeft;
  }


  public void setKilometersLeft(Integer kilometersLeft) {
    this.kilometersLeft = kilometersLeft;
  }


  public WagonResponse isDirty(Boolean isDirty) {
    
    this.isDirty = isDirty;
    return this;
  }

   /**
   * Get isDirty
   * @return isDirty
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsDirty() {
    return isDirty;
  }


  public void setIsDirty(Boolean isDirty) {
    this.isDirty = isDirty;
  }


  public WagonResponse note1(String note1) {
    
    this.note1 = note1;
    return this;
  }

   /**
   * Get note1
   * @return note1
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNote1() {
    return note1;
  }


  public void setNote1(String note1) {
    this.note1 = note1;
  }


  public WagonResponse note2(String note2) {
    
    this.note2 = note2;
    return this;
  }

   /**
   * Get note2
   * @return note2
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNote2() {
    return note2;
  }


  public void setNote2(String note2) {
    this.note2 = note2;
  }


  public WagonResponse parkId(Integer parkId) {
    
    this.parkId = parkId;
    return this;
  }

   /**
   * Get parkId
   * @return parkId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getParkId() {
    return parkId;
  }


  public void setParkId(Integer parkId) {
    this.parkId = parkId;
  }


  public WagonResponse stationId(Integer stationId) {
    
    this.stationId = stationId;
    return this;
  }

   /**
   * Get stationId
   * @return stationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getStationId() {
    return stationId;
  }


  public void setStationId(Integer stationId) {
    this.stationId = stationId;
  }


  public WagonResponse wayId(Integer wayId) {
    
    this.wayId = wayId;
    return this;
  }

   /**
   * Get wayId
   * @return wayId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getWayId() {
    return wayId;
  }


  public void setWayId(Integer wayId) {
    this.wayId = wayId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WagonResponse wagonResponse = (WagonResponse) o;
    return Objects.equals(this.id, wagonResponse.id) &&
        Objects.equals(this.inventoryNumber, wagonResponse.inventoryNumber) &&
        Objects.equals(this.position, wagonResponse.position) &&
        Objects.equals(this.type, wagonResponse.type) &&
        Objects.equals(this.isSick, wagonResponse.isSick) &&
        Objects.equals(this.cargo, wagonResponse.cargo) &&
        Objects.equals(this.operationState, wagonResponse.operationState) &&
        Objects.equals(this.idleDaysLength, wagonResponse.idleDaysLength) &&
        Objects.equals(this.owner, wagonResponse.owner) &&
        Objects.equals(this.isWithHatch, wagonResponse.isWithHatch) &&
        Objects.equals(this.loadCapacity, wagonResponse.loadCapacity) &&
        Objects.equals(this.daysToRepair, wagonResponse.daysToRepair) &&
        Objects.equals(this.kilometersLeft, wagonResponse.kilometersLeft) &&
        Objects.equals(this.isDirty, wagonResponse.isDirty) &&
        Objects.equals(this.note1, wagonResponse.note1) &&
        Objects.equals(this.note2, wagonResponse.note2) &&
        Objects.equals(this.parkId, wagonResponse.parkId) &&
        Objects.equals(this.stationId, wagonResponse.stationId) &&
        Objects.equals(this.wayId, wagonResponse.wayId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, inventoryNumber, position, type, isSick, cargo, operationState, idleDaysLength, owner, isWithHatch, loadCapacity, daysToRepair, kilometersLeft, isDirty, note1, note2, parkId, stationId, wayId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WagonResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    inventoryNumber: ").append(toIndentedString(inventoryNumber)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    isSick: ").append(toIndentedString(isSick)).append("\n");
    sb.append("    cargo: ").append(toIndentedString(cargo)).append("\n");
    sb.append("    operationState: ").append(toIndentedString(operationState)).append("\n");
    sb.append("    idleDaysLength: ").append(toIndentedString(idleDaysLength)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    isWithHatch: ").append(toIndentedString(isWithHatch)).append("\n");
    sb.append("    loadCapacity: ").append(toIndentedString(loadCapacity)).append("\n");
    sb.append("    daysToRepair: ").append(toIndentedString(daysToRepair)).append("\n");
    sb.append("    kilometersLeft: ").append(toIndentedString(kilometersLeft)).append("\n");
    sb.append("    isDirty: ").append(toIndentedString(isDirty)).append("\n");
    sb.append("    note1: ").append(toIndentedString(note1)).append("\n");
    sb.append("    note2: ").append(toIndentedString(note2)).append("\n");
    sb.append("    parkId: ").append(toIndentedString(parkId)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    wayId: ").append(toIndentedString(wayId)).append("\n");
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
    openapiFields.add("inventoryNumber");
    openapiFields.add("position");
    openapiFields.add("type");
    openapiFields.add("isSick");
    openapiFields.add("cargo");
    openapiFields.add("operationState");
    openapiFields.add("idleDaysLength");
    openapiFields.add("owner");
    openapiFields.add("isWithHatch");
    openapiFields.add("loadCapacity");
    openapiFields.add("daysToRepair");
    openapiFields.add("kilometersLeft");
    openapiFields.add("isDirty");
    openapiFields.add("note1");
    openapiFields.add("note2");
    openapiFields.add("parkId");
    openapiFields.add("stationId");
    openapiFields.add("wayId");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to WagonResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (WagonResponse.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in WagonResponse is not found in the empty JSON string", WagonResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!WagonResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `WagonResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("inventoryNumber") != null && !jsonObj.get("inventoryNumber").isJsonNull()) && !jsonObj.get("inventoryNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `inventoryNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("inventoryNumber").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      // validate the optional field `cargo`
      if (jsonObj.get("cargo") != null && !jsonObj.get("cargo").isJsonNull()) {
        Cargo.validateJsonObject(jsonObj.getAsJsonObject("cargo"));
      }
      if ((jsonObj.get("operationState") != null && !jsonObj.get("operationState").isJsonNull()) && !jsonObj.get("operationState").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `operationState` to be a primitive type in the JSON string but got `%s`", jsonObj.get("operationState").toString()));
      }
      if ((jsonObj.get("owner") != null && !jsonObj.get("owner").isJsonNull()) && !jsonObj.get("owner").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `owner` to be a primitive type in the JSON string but got `%s`", jsonObj.get("owner").toString()));
      }
      if ((jsonObj.get("note1") != null && !jsonObj.get("note1").isJsonNull()) && !jsonObj.get("note1").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `note1` to be a primitive type in the JSON string but got `%s`", jsonObj.get("note1").toString()));
      }
      if ((jsonObj.get("note2") != null && !jsonObj.get("note2").isJsonNull()) && !jsonObj.get("note2").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `note2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("note2").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!WagonResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'WagonResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<WagonResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(WagonResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<WagonResponse>() {
           @Override
           public void write(JsonWriter out, WagonResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public WagonResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of WagonResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of WagonResponse
  * @throws IOException if the JSON string is invalid with respect to WagonResponse
  */
  public static WagonResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, WagonResponse.class);
  }

 /**
  * Convert an instance of WagonResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

