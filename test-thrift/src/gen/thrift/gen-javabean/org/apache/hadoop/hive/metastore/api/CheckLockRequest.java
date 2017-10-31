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
public class CheckLockRequest implements org.apache.thrift.TBase<CheckLockRequest, CheckLockRequest._Fields>, java.io.Serializable, Cloneable, Comparable<CheckLockRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CheckLockRequest");

  private static final org.apache.thrift.protocol.TField LOCKID_FIELD_DESC = new org.apache.thrift.protocol.TField("lockid", org.apache.thrift.protocol.TType.I64, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CheckLockRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CheckLockRequestTupleSchemeFactory());
  }

  public long lockid; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LOCKID((short)1, "lockid");

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
        case 1: // LOCKID
          return LOCKID;
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
  private static final int __LOCKID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LOCKID, new org.apache.thrift.meta_data.FieldMetaData("lockid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CheckLockRequest.class, metaDataMap);
  }

  public CheckLockRequest() {
  }

  public CheckLockRequest(
    long lockid)
  {
    this();
    this.lockid = lockid;
    setLockidIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CheckLockRequest(CheckLockRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.lockid = other.lockid;
  }

  public CheckLockRequest deepCopy() {
    return new CheckLockRequest(this);
  }

  @Override
  public void clear() {
    setLockidIsSet(false);
    this.lockid = 0;
  }

  public long getLockid() {
    return this.lockid;
  }

  public CheckLockRequest setLockid(long lockid) {
    this.lockid = lockid;
    setLockidIsSet(true);
    return this;
  }

  public void unsetLockid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LOCKID_ISSET_ID);
  }

  /** Returns true if field lockid is set (has been assigned a value) and false otherwise */
  public boolean isSetLockid() {
    return EncodingUtils.testBit(__isset_bitfield, __LOCKID_ISSET_ID);
  }

  public void setLockidIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LOCKID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LOCKID:
      if (value == null) {
        unsetLockid();
      } else {
        setLockid((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LOCKID:
      return getLockid();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LOCKID:
      return isSetLockid();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CheckLockRequest)
      return this.equals((CheckLockRequest)that);
    return false;
  }

  public boolean equals(CheckLockRequest that) {
    if (that == null)
      return false;

    boolean this_present_lockid = true;
    boolean that_present_lockid = true;
    if (this_present_lockid || that_present_lockid) {
      if (!(this_present_lockid && that_present_lockid))
        return false;
      if (this.lockid != that.lockid)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_lockid = true;
    list.add(present_lockid);
    if (present_lockid)
      list.add(lockid);

    return list.hashCode();
  }

  @Override
  public int compareTo(CheckLockRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetLockid()).compareTo(other.isSetLockid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLockid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lockid, other.lockid);
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
    StringBuilder sb = new StringBuilder("CheckLockRequest(");
    boolean first = true;

    sb.append("lockid:");
    sb.append(this.lockid);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'lockid' because it's a primitive and you chose the non-beans generator.
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

  private static class CheckLockRequestStandardSchemeFactory implements SchemeFactory {
    public CheckLockRequestStandardScheme getScheme() {
      return new CheckLockRequestStandardScheme();
    }
  }

  private static class CheckLockRequestStandardScheme extends StandardScheme<CheckLockRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CheckLockRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LOCKID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.lockid = iprot.readI64();
              struct.setLockidIsSet(true);
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
      if (!struct.isSetLockid()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'lockid' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CheckLockRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(LOCKID_FIELD_DESC);
      oprot.writeI64(struct.lockid);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CheckLockRequestTupleSchemeFactory implements SchemeFactory {
    public CheckLockRequestTupleScheme getScheme() {
      return new CheckLockRequestTupleScheme();
    }
  }

  private static class CheckLockRequestTupleScheme extends TupleScheme<CheckLockRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CheckLockRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.lockid);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CheckLockRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.lockid = iprot.readI64();
      struct.setLockidIsSet(true);
    }
  }

}
