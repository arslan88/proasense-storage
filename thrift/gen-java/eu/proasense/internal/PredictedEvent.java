/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package eu.proasense.internal;

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-3-31")
public class PredictedEvent implements org.apache.thrift.TBase<PredictedEvent, PredictedEvent._Fields>, java.io.Serializable, Cloneable, Comparable<PredictedEvent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PredictedEvent");

  private static final org.apache.thrift.protocol.TField TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamp", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField PDF_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("pdfType", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField EVENT_PROPERTIES_FIELD_DESC = new org.apache.thrift.protocol.TField("eventProperties", org.apache.thrift.protocol.TType.MAP, (short)3);
  private static final org.apache.thrift.protocol.TField PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("params", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField TIMESTAMPS_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamps", org.apache.thrift.protocol.TType.LIST, (short)5);
  private static final org.apache.thrift.protocol.TField EVENT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("eventName", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PredictedEventStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PredictedEventTupleSchemeFactory());
  }

  public long timestamp; // required
  /**
   * 
   * @see PDFType
   */
  public PDFType pdfType; // required
  public Map<String,ComplexValue> eventProperties; // required
  public List<Double> params; // required
  public List<Long> timestamps; // optional
  public String eventName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TIMESTAMP((short)1, "timestamp"),
    /**
     * 
     * @see PDFType
     */
    PDF_TYPE((short)2, "pdfType"),
    EVENT_PROPERTIES((short)3, "eventProperties"),
    PARAMS((short)4, "params"),
    TIMESTAMPS((short)5, "timestamps"),
    EVENT_NAME((short)6, "eventName");

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
        case 1: // TIMESTAMP
          return TIMESTAMP;
        case 2: // PDF_TYPE
          return PDF_TYPE;
        case 3: // EVENT_PROPERTIES
          return EVENT_PROPERTIES;
        case 4: // PARAMS
          return PARAMS;
        case 5: // TIMESTAMPS
          return TIMESTAMPS;
        case 6: // EVENT_NAME
          return EVENT_NAME;
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
  private static final int __TIMESTAMP_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TIMESTAMPS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("timestamp", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.PDF_TYPE, new org.apache.thrift.meta_data.FieldMetaData("pdfType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PDFType.class)));
    tmpMap.put(_Fields.EVENT_PROPERTIES, new org.apache.thrift.meta_data.FieldMetaData("eventProperties", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ComplexValue.class))));
    tmpMap.put(_Fields.PARAMS, new org.apache.thrift.meta_data.FieldMetaData("params", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE))));
    tmpMap.put(_Fields.TIMESTAMPS, new org.apache.thrift.meta_data.FieldMetaData("timestamps", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64            , "long"))));
    tmpMap.put(_Fields.EVENT_NAME, new org.apache.thrift.meta_data.FieldMetaData("eventName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PredictedEvent.class, metaDataMap);
  }

  public PredictedEvent() {
  }

  public PredictedEvent(
    long timestamp,
    PDFType pdfType,
    Map<String,ComplexValue> eventProperties,
    List<Double> params,
    String eventName)
  {
    this();
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    this.pdfType = pdfType;
    this.eventProperties = eventProperties;
    this.params = params;
    this.eventName = eventName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PredictedEvent(PredictedEvent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.timestamp = other.timestamp;
    if (other.isSetPdfType()) {
      this.pdfType = other.pdfType;
    }
    if (other.isSetEventProperties()) {
      Map<String,ComplexValue> __this__eventProperties = new HashMap<String,ComplexValue>(other.eventProperties.size());
      for (Map.Entry<String, ComplexValue> other_element : other.eventProperties.entrySet()) {

        String other_element_key = other_element.getKey();
        ComplexValue other_element_value = other_element.getValue();

        String __this__eventProperties_copy_key = other_element_key;

        ComplexValue __this__eventProperties_copy_value = new ComplexValue(other_element_value);

        __this__eventProperties.put(__this__eventProperties_copy_key, __this__eventProperties_copy_value);
      }
      this.eventProperties = __this__eventProperties;
    }
    if (other.isSetParams()) {
      List<Double> __this__params = new ArrayList<Double>(other.params);
      this.params = __this__params;
    }
    if (other.isSetTimestamps()) {
      List<Long> __this__timestamps = new ArrayList<Long>(other.timestamps.size());
      for (Long other_element : other.timestamps) {
        __this__timestamps.add(other_element);
      }
      this.timestamps = __this__timestamps;
    }
    if (other.isSetEventName()) {
      this.eventName = other.eventName;
    }
  }

  public PredictedEvent deepCopy() {
    return new PredictedEvent(this);
  }

  @Override
  public void clear() {
    setTimestampIsSet(false);
    this.timestamp = 0;
    this.pdfType = null;
    this.eventProperties = null;
    this.params = null;
    this.timestamps = null;
    this.eventName = null;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public PredictedEvent setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMESTAMP_ISSET_ID, value);
  }

  /**
   * 
   * @see PDFType
   */
  public PDFType getPdfType() {
    return this.pdfType;
  }

  /**
   * 
   * @see PDFType
   */
  public PredictedEvent setPdfType(PDFType pdfType) {
    this.pdfType = pdfType;
    return this;
  }

  public void unsetPdfType() {
    this.pdfType = null;
  }

  /** Returns true if field pdfType is set (has been assigned a value) and false otherwise */
  public boolean isSetPdfType() {
    return this.pdfType != null;
  }

  public void setPdfTypeIsSet(boolean value) {
    if (!value) {
      this.pdfType = null;
    }
  }

  public int getEventPropertiesSize() {
    return (this.eventProperties == null) ? 0 : this.eventProperties.size();
  }

  public void putToEventProperties(String key, ComplexValue val) {
    if (this.eventProperties == null) {
      this.eventProperties = new HashMap<String,ComplexValue>();
    }
    this.eventProperties.put(key, val);
  }

  public Map<String,ComplexValue> getEventProperties() {
    return this.eventProperties;
  }

  public PredictedEvent setEventProperties(Map<String,ComplexValue> eventProperties) {
    this.eventProperties = eventProperties;
    return this;
  }

  public void unsetEventProperties() {
    this.eventProperties = null;
  }

  /** Returns true if field eventProperties is set (has been assigned a value) and false otherwise */
  public boolean isSetEventProperties() {
    return this.eventProperties != null;
  }

  public void setEventPropertiesIsSet(boolean value) {
    if (!value) {
      this.eventProperties = null;
    }
  }

  public int getParamsSize() {
    return (this.params == null) ? 0 : this.params.size();
  }

  public java.util.Iterator<Double> getParamsIterator() {
    return (this.params == null) ? null : this.params.iterator();
  }

  public void addToParams(double elem) {
    if (this.params == null) {
      this.params = new ArrayList<Double>();
    }
    this.params.add(elem);
  }

  public List<Double> getParams() {
    return this.params;
  }

  public PredictedEvent setParams(List<Double> params) {
    this.params = params;
    return this;
  }

  public void unsetParams() {
    this.params = null;
  }

  /** Returns true if field params is set (has been assigned a value) and false otherwise */
  public boolean isSetParams() {
    return this.params != null;
  }

  public void setParamsIsSet(boolean value) {
    if (!value) {
      this.params = null;
    }
  }

  public int getTimestampsSize() {
    return (this.timestamps == null) ? 0 : this.timestamps.size();
  }

  public java.util.Iterator<Long> getTimestampsIterator() {
    return (this.timestamps == null) ? null : this.timestamps.iterator();
  }

  public void addToTimestamps(long elem) {
    if (this.timestamps == null) {
      this.timestamps = new ArrayList<Long>();
    }
    this.timestamps.add(elem);
  }

  public List<Long> getTimestamps() {
    return this.timestamps;
  }

  public PredictedEvent setTimestamps(List<Long> timestamps) {
    this.timestamps = timestamps;
    return this;
  }

  public void unsetTimestamps() {
    this.timestamps = null;
  }

  /** Returns true if field timestamps is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamps() {
    return this.timestamps != null;
  }

  public void setTimestampsIsSet(boolean value) {
    if (!value) {
      this.timestamps = null;
    }
  }

  public String getEventName() {
    return this.eventName;
  }

  public PredictedEvent setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  public void unsetEventName() {
    this.eventName = null;
  }

  /** Returns true if field eventName is set (has been assigned a value) and false otherwise */
  public boolean isSetEventName() {
    return this.eventName != null;
  }

  public void setEventNameIsSet(boolean value) {
    if (!value) {
      this.eventName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((Long)value);
      }
      break;

    case PDF_TYPE:
      if (value == null) {
        unsetPdfType();
      } else {
        setPdfType((PDFType)value);
      }
      break;

    case EVENT_PROPERTIES:
      if (value == null) {
        unsetEventProperties();
      } else {
        setEventProperties((Map<String,ComplexValue>)value);
      }
      break;

    case PARAMS:
      if (value == null) {
        unsetParams();
      } else {
        setParams((List<Double>)value);
      }
      break;

    case TIMESTAMPS:
      if (value == null) {
        unsetTimestamps();
      } else {
        setTimestamps((List<Long>)value);
      }
      break;

    case EVENT_NAME:
      if (value == null) {
        unsetEventName();
      } else {
        setEventName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TIMESTAMP:
      return Long.valueOf(getTimestamp());

    case PDF_TYPE:
      return getPdfType();

    case EVENT_PROPERTIES:
      return getEventProperties();

    case PARAMS:
      return getParams();

    case TIMESTAMPS:
      return getTimestamps();

    case EVENT_NAME:
      return getEventName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TIMESTAMP:
      return isSetTimestamp();
    case PDF_TYPE:
      return isSetPdfType();
    case EVENT_PROPERTIES:
      return isSetEventProperties();
    case PARAMS:
      return isSetParams();
    case TIMESTAMPS:
      return isSetTimestamps();
    case EVENT_NAME:
      return isSetEventName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PredictedEvent)
      return this.equals((PredictedEvent)that);
    return false;
  }

  public boolean equals(PredictedEvent that) {
    if (that == null)
      return false;

    boolean this_present_timestamp = true;
    boolean that_present_timestamp = true;
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_pdfType = true && this.isSetPdfType();
    boolean that_present_pdfType = true && that.isSetPdfType();
    if (this_present_pdfType || that_present_pdfType) {
      if (!(this_present_pdfType && that_present_pdfType))
        return false;
      if (!this.pdfType.equals(that.pdfType))
        return false;
    }

    boolean this_present_eventProperties = true && this.isSetEventProperties();
    boolean that_present_eventProperties = true && that.isSetEventProperties();
    if (this_present_eventProperties || that_present_eventProperties) {
      if (!(this_present_eventProperties && that_present_eventProperties))
        return false;
      if (!this.eventProperties.equals(that.eventProperties))
        return false;
    }

    boolean this_present_params = true && this.isSetParams();
    boolean that_present_params = true && that.isSetParams();
    if (this_present_params || that_present_params) {
      if (!(this_present_params && that_present_params))
        return false;
      if (!this.params.equals(that.params))
        return false;
    }

    boolean this_present_timestamps = true && this.isSetTimestamps();
    boolean that_present_timestamps = true && that.isSetTimestamps();
    if (this_present_timestamps || that_present_timestamps) {
      if (!(this_present_timestamps && that_present_timestamps))
        return false;
      if (!this.timestamps.equals(that.timestamps))
        return false;
    }

    boolean this_present_eventName = true && this.isSetEventName();
    boolean that_present_eventName = true && that.isSetEventName();
    if (this_present_eventName || that_present_eventName) {
      if (!(this_present_eventName && that_present_eventName))
        return false;
      if (!this.eventName.equals(that.eventName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_timestamp = true;
    list.add(present_timestamp);
    if (present_timestamp)
      list.add(timestamp);

    boolean present_pdfType = true && (isSetPdfType());
    list.add(present_pdfType);
    if (present_pdfType)
      list.add(pdfType.getValue());

    boolean present_eventProperties = true && (isSetEventProperties());
    list.add(present_eventProperties);
    if (present_eventProperties)
      list.add(eventProperties);

    boolean present_params = true && (isSetParams());
    list.add(present_params);
    if (present_params)
      list.add(params);

    boolean present_timestamps = true && (isSetTimestamps());
    list.add(present_timestamps);
    if (present_timestamps)
      list.add(timestamps);

    boolean present_eventName = true && (isSetEventName());
    list.add(present_eventName);
    if (present_eventName)
      list.add(eventName);

    return list.hashCode();
  }

  @Override
  public int compareTo(PredictedEvent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTimestamp()).compareTo(other.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamp, other.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPdfType()).compareTo(other.isSetPdfType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPdfType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pdfType, other.pdfType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEventProperties()).compareTo(other.isSetEventProperties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEventProperties()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eventProperties, other.eventProperties);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParams()).compareTo(other.isSetParams());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParams()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.params, other.params);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimestamps()).compareTo(other.isSetTimestamps());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamps()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamps, other.timestamps);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEventName()).compareTo(other.isSetEventName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEventName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eventName, other.eventName);
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
    StringBuilder sb = new StringBuilder("PredictedEvent(");
    boolean first = true;

    sb.append("timestamp:");
    sb.append(this.timestamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pdfType:");
    if (this.pdfType == null) {
      sb.append("null");
    } else {
      sb.append(this.pdfType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("eventProperties:");
    if (this.eventProperties == null) {
      sb.append("null");
    } else {
      sb.append(this.eventProperties);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("params:");
    if (this.params == null) {
      sb.append("null");
    } else {
      sb.append(this.params);
    }
    first = false;
    if (isSetTimestamps()) {
      if (!first) sb.append(", ");
      sb.append("timestamps:");
      if (this.timestamps == null) {
        sb.append("null");
      } else {
        sb.append(this.timestamps);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("eventName:");
    if (this.eventName == null) {
      sb.append("null");
    } else {
      sb.append(this.eventName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'timestamp' because it's a primitive and you chose the non-beans generator.
    if (pdfType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pdfType' was not present! Struct: " + toString());
    }
    if (eventProperties == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'eventProperties' was not present! Struct: " + toString());
    }
    if (params == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'params' was not present! Struct: " + toString());
    }
    if (eventName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'eventName' was not present! Struct: " + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PredictedEventStandardSchemeFactory implements SchemeFactory {
    public PredictedEventStandardScheme getScheme() {
      return new PredictedEventStandardScheme();
    }
  }

  private static class PredictedEventStandardScheme extends StandardScheme<PredictedEvent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PredictedEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timestamp = iprot.readI64();
              struct.setTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PDF_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pdfType = eu.proasense.internal.PDFType.findByValue(iprot.readI32());
              struct.setPdfTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EVENT_PROPERTIES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map28 = iprot.readMapBegin();
                struct.eventProperties = new HashMap<String,ComplexValue>(2*_map28.size);
                String _key29;
                ComplexValue _val30;
                for (int _i31 = 0; _i31 < _map28.size; ++_i31)
                {
                  _key29 = iprot.readString();
                  _val30 = new ComplexValue();
                  _val30.read(iprot);
                  struct.eventProperties.put(_key29, _val30);
                }
                iprot.readMapEnd();
              }
              struct.setEventPropertiesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list32 = iprot.readListBegin();
                struct.params = new ArrayList<Double>(_list32.size);
                double _elem33;
                for (int _i34 = 0; _i34 < _list32.size; ++_i34)
                {
                  _elem33 = iprot.readDouble();
                  struct.params.add(_elem33);
                }
                iprot.readListEnd();
              }
              struct.setParamsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TIMESTAMPS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list35 = iprot.readListBegin();
                struct.timestamps = new ArrayList<Long>(_list35.size);
                long _elem36;
                for (int _i37 = 0; _i37 < _list35.size; ++_i37)
                {
                  _elem36 = iprot.readI64();
                  struct.timestamps.add(_elem36);
                }
                iprot.readListEnd();
              }
              struct.setTimestampsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // EVENT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.eventName = iprot.readString();
              struct.setEventNameIsSet(true);
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
      if (!struct.isSetTimestamp()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'timestamp' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, PredictedEvent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
      oprot.writeI64(struct.timestamp);
      oprot.writeFieldEnd();
      if (struct.pdfType != null) {
        oprot.writeFieldBegin(PDF_TYPE_FIELD_DESC);
        oprot.writeI32(struct.pdfType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.eventProperties != null) {
        oprot.writeFieldBegin(EVENT_PROPERTIES_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.eventProperties.size()));
          for (Map.Entry<String, ComplexValue> _iter38 : struct.eventProperties.entrySet())
          {
            oprot.writeString(_iter38.getKey());
            _iter38.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.params != null) {
        oprot.writeFieldBegin(PARAMS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.DOUBLE, struct.params.size()));
          for (double _iter39 : struct.params)
          {
            oprot.writeDouble(_iter39);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.timestamps != null) {
        if (struct.isSetTimestamps()) {
          oprot.writeFieldBegin(TIMESTAMPS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.timestamps.size()));
            for (long _iter40 : struct.timestamps)
            {
              oprot.writeI64(_iter40);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.eventName != null) {
        oprot.writeFieldBegin(EVENT_NAME_FIELD_DESC);
        oprot.writeString(struct.eventName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PredictedEventTupleSchemeFactory implements SchemeFactory {
    public PredictedEventTupleScheme getScheme() {
      return new PredictedEventTupleScheme();
    }
  }

  private static class PredictedEventTupleScheme extends TupleScheme<PredictedEvent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PredictedEvent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.timestamp);
      oprot.writeI32(struct.pdfType.getValue());
      {
        oprot.writeI32(struct.eventProperties.size());
        for (Map.Entry<String, ComplexValue> _iter41 : struct.eventProperties.entrySet())
        {
          oprot.writeString(_iter41.getKey());
          _iter41.getValue().write(oprot);
        }
      }
      {
        oprot.writeI32(struct.params.size());
        for (double _iter42 : struct.params)
        {
          oprot.writeDouble(_iter42);
        }
      }
      oprot.writeString(struct.eventName);
      BitSet optionals = new BitSet();
      if (struct.isSetTimestamps()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetTimestamps()) {
        {
          oprot.writeI32(struct.timestamps.size());
          for (long _iter43 : struct.timestamps)
          {
            oprot.writeI64(_iter43);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PredictedEvent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.timestamp = iprot.readI64();
      struct.setTimestampIsSet(true);
      struct.pdfType = eu.proasense.internal.PDFType.findByValue(iprot.readI32());
      struct.setPdfTypeIsSet(true);
      {
        org.apache.thrift.protocol.TMap _map44 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.eventProperties = new HashMap<String,ComplexValue>(2*_map44.size);
        String _key45;
        ComplexValue _val46;
        for (int _i47 = 0; _i47 < _map44.size; ++_i47)
        {
          _key45 = iprot.readString();
          _val46 = new ComplexValue();
          _val46.read(iprot);
          struct.eventProperties.put(_key45, _val46);
        }
      }
      struct.setEventPropertiesIsSet(true);
      {
        org.apache.thrift.protocol.TList _list48 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.DOUBLE, iprot.readI32());
        struct.params = new ArrayList<Double>(_list48.size);
        double _elem49;
        for (int _i50 = 0; _i50 < _list48.size; ++_i50)
        {
          _elem49 = iprot.readDouble();
          struct.params.add(_elem49);
        }
      }
      struct.setParamsIsSet(true);
      struct.eventName = iprot.readString();
      struct.setEventNameIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list51 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.timestamps = new ArrayList<Long>(_list51.size);
          long _elem52;
          for (int _i53 = 0; _i53 < _list51.size; ++_i53)
          {
            _elem52 = iprot.readI64();
            struct.timestamps.add(_elem52);
          }
        }
        struct.setTimestampsIsSet(true);
      }
    }
  }

}
