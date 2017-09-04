/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-08-08")
public class Function implements org.apache.thrift.TBase<Function, Function._Fields>, java.io.Serializable, Cloneable, Comparable<Function> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Function");

  private static final org.apache.thrift.protocol.TField FUNCTION_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("functionName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dbName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CLASS_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("className", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField OWNER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("ownerName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField OWNER_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("ownerType", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("createTime", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField FUNCTION_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("functionType", org.apache.thrift.protocol.TType.I32, (short)7);
  private static final org.apache.thrift.protocol.TField RESOURCE_URIS_FIELD_DESC = new org.apache.thrift.protocol.TField("resourceUris", org.apache.thrift.protocol.TType.LIST, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FunctionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FunctionTupleSchemeFactory());
  }

  public String functionName; // required
  public String dbName; // required
  public String className; // required
  public String ownerName; // required
  /**
   * 
   * @see PrincipalType
   */
  public PrincipalType ownerType; // required
  public int createTime; // required
  /**
   * 
   * @see FunctionType
   */
  public FunctionType functionType; // required
  public List<ResourceUri> resourceUris; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FUNCTION_NAME((short)1, "functionName"),
    DB_NAME((short)2, "dbName"),
    CLASS_NAME((short)3, "className"),
    OWNER_NAME((short)4, "ownerName"),
    /**
     * 
     * @see PrincipalType
     */
    OWNER_TYPE((short)5, "ownerType"),
    CREATE_TIME((short)6, "createTime"),
    /**
     * 
     * @see FunctionType
     */
    FUNCTION_TYPE((short)7, "functionType"),
    RESOURCE_URIS((short)8, "resourceUris");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FUNCTION_NAME
          return FUNCTION_NAME;
        case 2: // DB_NAME
          return DB_NAME;
        case 3: // CLASS_NAME
          return CLASS_NAME;
        case 4: // OWNER_NAME
          return OWNER_NAME;
        case 5: // OWNER_TYPE
          return OWNER_TYPE;
        case 6: // CREATE_TIME
          return CREATE_TIME;
        case 7: // FUNCTION_TYPE
          return FUNCTION_TYPE;
        case 8: // RESOURCE_URIS
          return RESOURCE_URIS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CREATETIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FUNCTION_NAME, new org.apache.thrift.meta_data.FieldMetaData("functionName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("dbName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CLASS_NAME, new org.apache.thrift.meta_data.FieldMetaData("className", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OWNER_NAME, new org.apache.thrift.meta_data.FieldMetaData("ownerName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OWNER_TYPE, new org.apache.thrift.meta_data.FieldMetaData("ownerType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PrincipalType.class)));
    tmpMap.put(_Fields.CREATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("createTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FUNCTION_TYPE, new org.apache.thrift.meta_data.FieldMetaData("functionType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FunctionType.class)));
    tmpMap.put(_Fields.RESOURCE_URIS, new org.apache.thrift.meta_data.FieldMetaData("resourceUris", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ResourceUri.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Function.class, metaDataMap);
  }

  public Function() {
  }

  public Function(
    String functionName,
    String dbName,
    String className,
    String ownerName,
    PrincipalType ownerType,
    int createTime,
    FunctionType functionType,
    List<ResourceUri> resourceUris)
  {
    this();
    this.functionName = functionName;
    this.dbName = dbName;
    this.className = className;
    this.ownerName = ownerName;
    this.ownerType = ownerType;
    this.createTime = createTime;
    setCreateTimeIsSet(true);
    this.functionType = functionType;
    this.resourceUris = resourceUris;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Function(Function other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFunctionName()) {
      this.functionName = other.functionName;
    }
    if (other.isSetDbName()) {
      this.dbName = other.dbName;
    }
    if (other.isSetClassName()) {
      this.className = other.className;
    }
    if (other.isSetOwnerName()) {
      this.ownerName = other.ownerName;
    }
    if (other.isSetOwnerType()) {
      this.ownerType = other.ownerType;
    }
    this.createTime = other.createTime;
    if (other.isSetFunctionType()) {
      this.functionType = other.functionType;
    }
    if (other.isSetResourceUris()) {
      List<ResourceUri> __this__resourceUris = new ArrayList<ResourceUri>(other.resourceUris.size());
      for (ResourceUri other_element : other.resourceUris) {
        __this__resourceUris.add(new ResourceUri(other_element));
      }
      this.resourceUris = __this__resourceUris;
    }
  }

  public Function deepCopy() {
    return new Function(this);
  }

  @Override
  public void clear() {
    this.functionName = null;
    this.dbName = null;
    this.className = null;
    this.ownerName = null;
    this.ownerType = null;
    setCreateTimeIsSet(false);
    this.createTime = 0;
    this.functionType = null;
    this.resourceUris = null;
  }

  public String getFunctionName() {
    return this.functionName;
  }

  public Function setFunctionName(String functionName) {
    this.functionName = functionName;
    return this;
  }

  public void unsetFunctionName() {
    this.functionName = null;
  }

  /** Returns true if field functionName is set (has been assigned a value) and false otherwise */
  public boolean isSetFunctionName() {
    return this.functionName != null;
  }

  public void setFunctionNameIsSet(boolean value) {
    if (!value) {
      this.functionName = null;
    }
  }

  public String getDbName() {
    return this.dbName;
  }

  public Function setDbName(String dbName) {
    this.dbName = dbName;
    return this;
  }

  public void unsetDbName() {
    this.dbName = null;
  }

  /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
  public boolean isSetDbName() {
    return this.dbName != null;
  }

  public void setDbNameIsSet(boolean value) {
    if (!value) {
      this.dbName = null;
    }
  }

  public String getClassName() {
    return this.className;
  }

  public Function setClassName(String className) {
    this.className = className;
    return this;
  }

  public void unsetClassName() {
    this.className = null;
  }

  /** Returns true if field className is set (has been assigned a value) and false otherwise */
  public boolean isSetClassName() {
    return this.className != null;
  }

  public void setClassNameIsSet(boolean value) {
    if (!value) {
      this.className = null;
    }
  }

  public String getOwnerName() {
    return this.ownerName;
  }

  public Function setOwnerName(String ownerName) {
    this.ownerName = ownerName;
    return this;
  }

  public void unsetOwnerName() {
    this.ownerName = null;
  }

  /** Returns true if field ownerName is set (has been assigned a value) and false otherwise */
  public boolean isSetOwnerName() {
    return this.ownerName != null;
  }

  public void setOwnerNameIsSet(boolean value) {
    if (!value) {
      this.ownerName = null;
    }
  }

  /**
   * 
   * @see PrincipalType
   */
  public PrincipalType getOwnerType() {
    return this.ownerType;
  }

  /**
   * 
   * @see PrincipalType
   */
  public Function setOwnerType(PrincipalType ownerType) {
    this.ownerType = ownerType;
    return this;
  }

  public void unsetOwnerType() {
    this.ownerType = null;
  }

  /** Returns true if field ownerType is set (has been assigned a value) and false otherwise */
  public boolean isSetOwnerType() {
    return this.ownerType != null;
  }

  public void setOwnerTypeIsSet(boolean value) {
    if (!value) {
      this.ownerType = null;
    }
  }

  public int getCreateTime() {
    return this.createTime;
  }

  public Function setCreateTime(int createTime) {
    this.createTime = createTime;
    setCreateTimeIsSet(true);
    return this;
  }

  public void unsetCreateTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CREATETIME_ISSET_ID);
  }

  /** Returns true if field createTime is set (has been assigned a value) and false otherwise */
  public boolean isSetCreateTime() {
    return EncodingUtils.testBit(__isset_bitfield, __CREATETIME_ISSET_ID);
  }

  public void setCreateTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CREATETIME_ISSET_ID, value);
  }

  /**
   * 
   * @see FunctionType
   */
  public FunctionType getFunctionType() {
    return this.functionType;
  }

  /**
   * 
   * @see FunctionType
   */
  public Function setFunctionType(FunctionType functionType) {
    this.functionType = functionType;
    return this;
  }

  public void unsetFunctionType() {
    this.functionType = null;
  }

  /** Returns true if field functionType is set (has been assigned a value) and false otherwise */
  public boolean isSetFunctionType() {
    return this.functionType != null;
  }

  public void setFunctionTypeIsSet(boolean value) {
    if (!value) {
      this.functionType = null;
    }
  }

  public int getResourceUrisSize() {
    return (this.resourceUris == null) ? 0 : this.resourceUris.size();
  }

  public java.util.Iterator<ResourceUri> getResourceUrisIterator() {
    return (this.resourceUris == null) ? null : this.resourceUris.iterator();
  }

  public void addToResourceUris(ResourceUri elem) {
    if (this.resourceUris == null) {
      this.resourceUris = new ArrayList<ResourceUri>();
    }
    this.resourceUris.add(elem);
  }

  public List<ResourceUri> getResourceUris() {
    return this.resourceUris;
  }

  public Function setResourceUris(List<ResourceUri> resourceUris) {
    this.resourceUris = resourceUris;
    return this;
  }

  public void unsetResourceUris() {
    this.resourceUris = null;
  }

  /** Returns true if field resourceUris is set (has been assigned a value) and false otherwise */
  public boolean isSetResourceUris() {
    return this.resourceUris != null;
  }

  public void setResourceUrisIsSet(boolean value) {
    if (!value) {
      this.resourceUris = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FUNCTION_NAME:
      if (value == null) {
        unsetFunctionName();
      } else {
        setFunctionName((String)value);
      }
      break;

    case DB_NAME:
      if (value == null) {
        unsetDbName();
      } else {
        setDbName((String)value);
      }
      break;

    case CLASS_NAME:
      if (value == null) {
        unsetClassName();
      } else {
        setClassName((String)value);
      }
      break;

    case OWNER_NAME:
      if (value == null) {
        unsetOwnerName();
      } else {
        setOwnerName((String)value);
      }
      break;

    case OWNER_TYPE:
      if (value == null) {
        unsetOwnerType();
      } else {
        setOwnerType((PrincipalType)value);
      }
      break;

    case CREATE_TIME:
      if (value == null) {
        unsetCreateTime();
      } else {
        setCreateTime((Integer)value);
      }
      break;

    case FUNCTION_TYPE:
      if (value == null) {
        unsetFunctionType();
      } else {
        setFunctionType((FunctionType)value);
      }
      break;

    case RESOURCE_URIS:
      if (value == null) {
        unsetResourceUris();
      } else {
        setResourceUris((List<ResourceUri>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FUNCTION_NAME:
      return getFunctionName();

    case DB_NAME:
      return getDbName();

    case CLASS_NAME:
      return getClassName();

    case OWNER_NAME:
      return getOwnerName();

    case OWNER_TYPE:
      return getOwnerType();

    case CREATE_TIME:
      return getCreateTime();

    case FUNCTION_TYPE:
      return getFunctionType();

    case RESOURCE_URIS:
      return getResourceUris();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FUNCTION_NAME:
      return isSetFunctionName();
    case DB_NAME:
      return isSetDbName();
    case CLASS_NAME:
      return isSetClassName();
    case OWNER_NAME:
      return isSetOwnerName();
    case OWNER_TYPE:
      return isSetOwnerType();
    case CREATE_TIME:
      return isSetCreateTime();
    case FUNCTION_TYPE:
      return isSetFunctionType();
    case RESOURCE_URIS:
      return isSetResourceUris();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Function)
      return this.equals((Function)that);
    return false;
  }

  public boolean equals(Function that) {
    if (that == null)
      return false;

    boolean this_present_functionName = true && this.isSetFunctionName();
    boolean that_present_functionName = true && that.isSetFunctionName();
    if (this_present_functionName || that_present_functionName) {
      if (!(this_present_functionName && that_present_functionName))
        return false;
      if (!this.functionName.equals(that.functionName))
        return false;
    }

    boolean this_present_dbName = true && this.isSetDbName();
    boolean that_present_dbName = true && that.isSetDbName();
    if (this_present_dbName || that_present_dbName) {
      if (!(this_present_dbName && that_present_dbName))
        return false;
      if (!this.dbName.equals(that.dbName))
        return false;
    }

    boolean this_present_className = true && this.isSetClassName();
    boolean that_present_className = true && that.isSetClassName();
    if (this_present_className || that_present_className) {
      if (!(this_present_className && that_present_className))
        return false;
      if (!this.className.equals(that.className))
        return false;
    }

    boolean this_present_ownerName = true && this.isSetOwnerName();
    boolean that_present_ownerName = true && that.isSetOwnerName();
    if (this_present_ownerName || that_present_ownerName) {
      if (!(this_present_ownerName && that_present_ownerName))
        return false;
      if (!this.ownerName.equals(that.ownerName))
        return false;
    }

    boolean this_present_ownerType = true && this.isSetOwnerType();
    boolean that_present_ownerType = true && that.isSetOwnerType();
    if (this_present_ownerType || that_present_ownerType) {
      if (!(this_present_ownerType && that_present_ownerType))
        return false;
      if (!this.ownerType.equals(that.ownerType))
        return false;
    }

    boolean this_present_createTime = true;
    boolean that_present_createTime = true;
    if (this_present_createTime || that_present_createTime) {
      if (!(this_present_createTime && that_present_createTime))
        return false;
      if (this.createTime != that.createTime)
        return false;
    }

    boolean this_present_functionType = true && this.isSetFunctionType();
    boolean that_present_functionType = true && that.isSetFunctionType();
    if (this_present_functionType || that_present_functionType) {
      if (!(this_present_functionType && that_present_functionType))
        return false;
      if (!this.functionType.equals(that.functionType))
        return false;
    }

    boolean this_present_resourceUris = true && this.isSetResourceUris();
    boolean that_present_resourceUris = true && that.isSetResourceUris();
    if (this_present_resourceUris || that_present_resourceUris) {
      if (!(this_present_resourceUris && that_present_resourceUris))
        return false;
      if (!this.resourceUris.equals(that.resourceUris))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_functionName = true && (isSetFunctionName());
    list.add(present_functionName);
    if (present_functionName)
      list.add(functionName);

    boolean present_dbName = true && (isSetDbName());
    list.add(present_dbName);
    if (present_dbName)
      list.add(dbName);

    boolean present_className = true && (isSetClassName());
    list.add(present_className);
    if (present_className)
      list.add(className);

    boolean present_ownerName = true && (isSetOwnerName());
    list.add(present_ownerName);
    if (present_ownerName)
      list.add(ownerName);

    boolean present_ownerType = true && (isSetOwnerType());
    list.add(present_ownerType);
    if (present_ownerType)
      list.add(ownerType.getValue());

    boolean present_createTime = true;
    list.add(present_createTime);
    if (present_createTime)
      list.add(createTime);

    boolean present_functionType = true && (isSetFunctionType());
    list.add(present_functionType);
    if (present_functionType)
      list.add(functionType.getValue());

    boolean present_resourceUris = true && (isSetResourceUris());
    list.add(present_resourceUris);
    if (present_resourceUris)
      list.add(resourceUris);

    return list.hashCode();
  }

  @Override
  public int compareTo(Function other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetFunctionName()).compareTo(other.isSetFunctionName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFunctionName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.functionName, other.functionName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDbName()).compareTo(other.isSetDbName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetClassName()).compareTo(other.isSetClassName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClassName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.className, other.className);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOwnerName()).compareTo(other.isSetOwnerName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOwnerName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ownerName, other.ownerName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOwnerType()).compareTo(other.isSetOwnerType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOwnerType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ownerType, other.ownerType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCreateTime()).compareTo(other.isSetCreateTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreateTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTime, other.createTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFunctionType()).compareTo(other.isSetFunctionType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFunctionType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.functionType, other.functionType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetResourceUris()).compareTo(other.isSetResourceUris());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourceUris()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourceUris, other.resourceUris);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Function(");
    boolean first = true;

    sb.append("functionName:");
    if (this.functionName == null) {
      sb.append("null");
    } else {
      sb.append(this.functionName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbName:");
    if (this.dbName == null) {
      sb.append("null");
    } else {
      sb.append(this.dbName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("className:");
    if (this.className == null) {
      sb.append("null");
    } else {
      sb.append(this.className);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ownerName:");
    if (this.ownerName == null) {
      sb.append("null");
    } else {
      sb.append(this.ownerName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ownerType:");
    if (this.ownerType == null) {
      sb.append("null");
    } else {
      sb.append(this.ownerType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("createTime:");
    sb.append(this.createTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("functionType:");
    if (this.functionType == null) {
      sb.append("null");
    } else {
      sb.append(this.functionType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("resourceUris:");
    if (this.resourceUris == null) {
      sb.append("null");
    } else {
      sb.append(this.resourceUris);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FunctionStandardSchemeFactory implements SchemeFactory {
    public FunctionStandardScheme getScheme() {
      return new FunctionStandardScheme();
    }
  }

  private static class FunctionStandardScheme extends StandardScheme<Function> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Function struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FUNCTION_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.functionName = iprot.readString();
              struct.setFunctionNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbName = iprot.readString();
              struct.setDbNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CLASS_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.className = iprot.readString();
              struct.setClassNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // OWNER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ownerName = iprot.readString();
              struct.setOwnerNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // OWNER_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ownerType = org.apache.hadoop.hive.metastore.api.PrincipalType.findByValue(iprot.readI32());
              struct.setOwnerTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // CREATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.createTime = iprot.readI32();
              struct.setCreateTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // FUNCTION_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.functionType = org.apache.hadoop.hive.metastore.api.FunctionType.findByValue(iprot.readI32());
              struct.setFunctionTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // RESOURCE_URIS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list420 = iprot.readListBegin();
                struct.resourceUris = new ArrayList<ResourceUri>(_list420.size);
                ResourceUri _elem421;
                for (int _i422 = 0; _i422 < _list420.size; ++_i422)
                {
                  _elem421 = new ResourceUri();
                  _elem421.read(iprot);
                  struct.resourceUris.add(_elem421);
                }
                iprot.readListEnd();
              }
              struct.setResourceUrisIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Function struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.functionName != null) {
        oprot.writeFieldBegin(FUNCTION_NAME_FIELD_DESC);
        oprot.writeString(struct.functionName);
        oprot.writeFieldEnd();
      }
      if (struct.dbName != null) {
        oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        oprot.writeString(struct.dbName);
        oprot.writeFieldEnd();
      }
      if (struct.className != null) {
        oprot.writeFieldBegin(CLASS_NAME_FIELD_DESC);
        oprot.writeString(struct.className);
        oprot.writeFieldEnd();
      }
      if (struct.ownerName != null) {
        oprot.writeFieldBegin(OWNER_NAME_FIELD_DESC);
        oprot.writeString(struct.ownerName);
        oprot.writeFieldEnd();
      }
      if (struct.ownerType != null) {
        oprot.writeFieldBegin(OWNER_TYPE_FIELD_DESC);
        oprot.writeI32(struct.ownerType.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
      oprot.writeI32(struct.createTime);
      oprot.writeFieldEnd();
      if (struct.functionType != null) {
        oprot.writeFieldBegin(FUNCTION_TYPE_FIELD_DESC);
        oprot.writeI32(struct.functionType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.resourceUris != null) {
        oprot.writeFieldBegin(RESOURCE_URIS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.resourceUris.size()));
          for (ResourceUri _iter423 : struct.resourceUris)
          {
            _iter423.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FunctionTupleSchemeFactory implements SchemeFactory {
    public FunctionTupleScheme getScheme() {
      return new FunctionTupleScheme();
    }
  }

  private static class FunctionTupleScheme extends TupleScheme<Function> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Function struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetFunctionName()) {
        optionals.set(0);
      }
      if (struct.isSetDbName()) {
        optionals.set(1);
      }
      if (struct.isSetClassName()) {
        optionals.set(2);
      }
      if (struct.isSetOwnerName()) {
        optionals.set(3);
      }
      if (struct.isSetOwnerType()) {
        optionals.set(4);
      }
      if (struct.isSetCreateTime()) {
        optionals.set(5);
      }
      if (struct.isSetFunctionType()) {
        optionals.set(6);
      }
      if (struct.isSetResourceUris()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetFunctionName()) {
        oprot.writeString(struct.functionName);
      }
      if (struct.isSetDbName()) {
        oprot.writeString(struct.dbName);
      }
      if (struct.isSetClassName()) {
        oprot.writeString(struct.className);
      }
      if (struct.isSetOwnerName()) {
        oprot.writeString(struct.ownerName);
      }
      if (struct.isSetOwnerType()) {
        oprot.writeI32(struct.ownerType.getValue());
      }
      if (struct.isSetCreateTime()) {
        oprot.writeI32(struct.createTime);
      }
      if (struct.isSetFunctionType()) {
        oprot.writeI32(struct.functionType.getValue());
      }
      if (struct.isSetResourceUris()) {
        {
          oprot.writeI32(struct.resourceUris.size());
          for (ResourceUri _iter424 : struct.resourceUris)
          {
            _iter424.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Function struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.functionName = iprot.readString();
        struct.setFunctionNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.dbName = iprot.readString();
        struct.setDbNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.className = iprot.readString();
        struct.setClassNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ownerName = iprot.readString();
        struct.setOwnerNameIsSet(true);
      }
      if (incoming.get(4)) {
        struct.ownerType = org.apache.hadoop.hive.metastore.api.PrincipalType.findByValue(iprot.readI32());
        struct.setOwnerTypeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.createTime = iprot.readI32();
        struct.setCreateTimeIsSet(true);
      }
      if (incoming.get(6)) {
        struct.functionType = org.apache.hadoop.hive.metastore.api.FunctionType.findByValue(iprot.readI32());
        struct.setFunctionTypeIsSet(true);
      }
      if (incoming.get(7)) {
        {
          org.apache.thrift.protocol.TList _list425 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourceUris = new ArrayList<ResourceUri>(_list425.size);
          ResourceUri _elem426;
          for (int _i427 = 0; _i427 < _list425.size; ++_i427)
          {
            _elem426 = new ResourceUri();
            _elem426.read(iprot);
            struct.resourceUris.add(_elem426);
          }
        }
        struct.setResourceUrisIsSet(true);
      }
    }
  }

}

