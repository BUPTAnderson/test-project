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
public class GetPrincipalsInRoleRequest implements org.apache.thrift.TBase<GetPrincipalsInRoleRequest, GetPrincipalsInRoleRequest._Fields>, java.io.Serializable, Cloneable, Comparable<GetPrincipalsInRoleRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetPrincipalsInRoleRequest");

  private static final org.apache.thrift.protocol.TField ROLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("roleName", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GetPrincipalsInRoleRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GetPrincipalsInRoleRequestTupleSchemeFactory());
  }

  public String roleName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROLE_NAME((short)1, "roleName");

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
        case 1: // ROLE_NAME
          return ROLE_NAME;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("roleName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetPrincipalsInRoleRequest.class, metaDataMap);
  }

  public GetPrincipalsInRoleRequest() {
  }

  public GetPrincipalsInRoleRequest(
    String roleName)
  {
    this();
    this.roleName = roleName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GetPrincipalsInRoleRequest(GetPrincipalsInRoleRequest other) {
    if (other.isSetRoleName()) {
      this.roleName = other.roleName;
    }
  }

  public GetPrincipalsInRoleRequest deepCopy() {
    return new GetPrincipalsInRoleRequest(this);
  }

  @Override
  public void clear() {
    this.roleName = null;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public GetPrincipalsInRoleRequest setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public void unsetRoleName() {
    this.roleName = null;
  }

  /** Returns true if field roleName is set (has been assigned a value) and false otherwise */
  public boolean isSetRoleName() {
    return this.roleName != null;
  }

  public void setRoleNameIsSet(boolean value) {
    if (!value) {
      this.roleName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ROLE_NAME:
      if (value == null) {
        unsetRoleName();
      } else {
        setRoleName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ROLE_NAME:
      return getRoleName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ROLE_NAME:
      return isSetRoleName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GetPrincipalsInRoleRequest)
      return this.equals((GetPrincipalsInRoleRequest)that);
    return false;
  }

  public boolean equals(GetPrincipalsInRoleRequest that) {
    if (that == null)
      return false;

    boolean this_present_roleName = true && this.isSetRoleName();
    boolean that_present_roleName = true && that.isSetRoleName();
    if (this_present_roleName || that_present_roleName) {
      if (!(this_present_roleName && that_present_roleName))
        return false;
      if (!this.roleName.equals(that.roleName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_roleName = true && (isSetRoleName());
    list.add(present_roleName);
    if (present_roleName)
      list.add(roleName);

    return list.hashCode();
  }

  @Override
  public int compareTo(GetPrincipalsInRoleRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRoleName()).compareTo(other.isSetRoleName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRoleName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.roleName, other.roleName);
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
    StringBuilder sb = new StringBuilder("GetPrincipalsInRoleRequest(");
    boolean first = true;

    sb.append("roleName:");
    if (this.roleName == null) {
      sb.append("null");
    } else {
      sb.append(this.roleName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (roleName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'roleName' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GetPrincipalsInRoleRequestStandardSchemeFactory implements SchemeFactory {
    public GetPrincipalsInRoleRequestStandardScheme getScheme() {
      return new GetPrincipalsInRoleRequestStandardScheme();
    }
  }

  private static class GetPrincipalsInRoleRequestStandardScheme extends StandardScheme<GetPrincipalsInRoleRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GetPrincipalsInRoleRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ROLE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.roleName = iprot.readString();
              struct.setRoleNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GetPrincipalsInRoleRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.roleName != null) {
        oprot.writeFieldBegin(ROLE_NAME_FIELD_DESC);
        oprot.writeString(struct.roleName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GetPrincipalsInRoleRequestTupleSchemeFactory implements SchemeFactory {
    public GetPrincipalsInRoleRequestTupleScheme getScheme() {
      return new GetPrincipalsInRoleRequestTupleScheme();
    }
  }

  private static class GetPrincipalsInRoleRequestTupleScheme extends TupleScheme<GetPrincipalsInRoleRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetPrincipalsInRoleRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.roleName);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetPrincipalsInRoleRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.roleName = iprot.readString();
      struct.setRoleNameIsSet(true);
    }
  }

}

