package gipsy.GEE.multitier.DGT;

import gipsy.GEE.IDP.demands.Demand;
import gipsy.GEE.IDP.demands.DemandSignature;
import gipsy.GEE.IDP.demands.IDemand;
import gipsy.GEE.multitier.DST.ws.WSDSTWrapper;

public class DGTStub extends org.apache.axis.client.Stub implements WSDSTWrapper {
	    private java.util.Vector cachedSerClasses = new java.util.Vector();
	    private java.util.Vector cachedSerQNames = new java.util.Vector();
	    private java.util.Vector cachedSerFactories = new java.util.Vector();
	    private java.util.Vector cachedDeserFactories = new java.util.Vector();

	    static org.apache.axis.description.OperationDesc [] _operations;

	    static {
	        _operations = new org.apache.axis.description.OperationDesc[3];
	        _initOperationDesc1();
	    }

	    private static void _initOperationDesc1(){
	        org.apache.axis.description.OperationDesc oper;
	        org.apache.axis.description.ParameterDesc param;
	        oper = new org.apache.axis.description.OperationDesc();
	        oper.setName("getHashTableValue");
	        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://test", "podSignature"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://test", "DemandSignature"), DemandSignature.class, false, false);
	        oper.addParameter(param);
	        oper.setReturnType(new javax.xml.namespace.QName("http://test", "WSDemand"));
	        oper.setReturnClass(Demand.class);
	        oper.setReturnQName(new javax.xml.namespace.QName("http://test", "getHashTableValueReturn"));
	        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
	        oper.setUse(org.apache.axis.constants.Use.LITERAL);
	        _operations[0] = oper;

	        oper = new org.apache.axis.description.OperationDesc();
	        oper.setName("setHashTable");
	        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://test", "poIdObj"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://test", "Demand"), Demand.class, false, false);
	        oper.addParameter(param);
	        oper.setReturnType(new javax.xml.namespace.QName("http://test", "WSDemandSignature"));
	        oper.setReturnClass(DemandSignature.class);
	        oper.setReturnQName(new javax.xml.namespace.QName("http://test", "setHashTableReturn"));
	        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
	        oper.setUse(org.apache.axis.constants.Use.LITERAL);
	        _operations[1] = oper;

	        oper = new org.apache.axis.description.OperationDesc();
	        oper.setName("getPendingDemand");
	        oper.setReturnType(new javax.xml.namespace.QName("http://test", "Demand"));
	        oper.setReturnClass(Demand.class);
	        oper.setReturnQName(new javax.xml.namespace.QName("http://test", "getPendingDemandReturn"));
	        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
	        oper.setUse(org.apache.axis.constants.Use.LITERAL);
	        _operations[2] = oper;

	    }

	    public DGTStub() throws org.apache.axis.AxisFault {
	         this(null);
	    }

	    public DGTStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
	         this(service);
	         super.cachedEndpoint = endpointURL;
	    }

	    public DGTStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
	        if (service == null) {
	            super.service = new org.apache.axis.client.Service();
	        } else {
	            super.service = service;
	        }
	        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
	            java.lang.Class cls;
	            javax.xml.namespace.QName qName;
	            javax.xml.namespace.QName qName2;
	            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
	            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
	            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
	            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
	            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
	            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
	            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
	            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
	            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
	            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
	            qName = new javax.xml.namespace.QName("http://test", "WSDemand");
	            cachedSerQNames.add(qName);
	            cls = Demand.class;
	            cachedSerClasses.add(cls);
	            cachedSerFactories.add(beansf);
	            cachedDeserFactories.add(beandf);

	            qName = new javax.xml.namespace.QName("http://test", "WSDemandSignature");
	            cachedSerQNames.add(qName);
	            cls = DemandSignature.class;
	            cachedSerClasses.add(cls);
	            cachedSerFactories.add(beansf);
	            cachedDeserFactories.add(beandf);

	    }

	    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
	        try {
	            org.apache.axis.client.Call _call = super._createCall();
	            if (super.maintainSessionSet) {
	                _call.setMaintainSession(super.maintainSession);
	            }
	            if (super.cachedUsername != null) {
	                _call.setUsername(super.cachedUsername);
	            }
	            if (super.cachedPassword != null) {
	                _call.setPassword(super.cachedPassword);
	            }
	            if (super.cachedEndpoint != null) {
	                _call.setTargetEndpointAddress(super.cachedEndpoint);
	            }
	            if (super.cachedTimeout != null) {
	                _call.setTimeout(super.cachedTimeout);
	            }
	            if (super.cachedPortName != null) {
	                _call.setPortName(super.cachedPortName);
	            }
	            java.util.Enumeration keys = super.cachedProperties.keys();
	            while (keys.hasMoreElements()) {
	                java.lang.String key = (java.lang.String) keys.nextElement();
	                _call.setProperty(key, super.cachedProperties.get(key));
	            }
	            // All the type mapping information is registered
	            // when the first call is made.
	            // The type mapping information is actually registered in
	            // the TypeMappingRegistry of the service, which
	            // is the reason why registration is only needed for the first call.
	            synchronized (this) {
	                if (firstCall()) {
	                    // must set encoding style before registering serializers
	                    _call.setEncodingStyle(null);
	                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
	                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
	                        javax.xml.namespace.QName qName =
	                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
	                        java.lang.Object x = cachedSerFactories.get(i);
	                        if (x instanceof Class) {
	                            java.lang.Class sf = (java.lang.Class)
	                                 cachedSerFactories.get(i);
	                            java.lang.Class df = (java.lang.Class)
	                                 cachedDeserFactories.get(i);
	                            _call.registerTypeMapping(cls, qName, sf, df, false);
	                        }
	                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
	                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
	                                 cachedSerFactories.get(i);
	                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
	                                 cachedDeserFactories.get(i);
	                            _call.registerTypeMapping(cls, qName, sf, df, false);
	                        }
	                    }
	                }
	            }
	            return _call;
	        }
	        catch (java.lang.Throwable _t) {
	            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
	        }
	    }

	    public IDemand getHashTableValue(DemandSignature podSignature) throws java.rmi.RemoteException {
	        if (super.cachedEndpoint == null) {
	            throw new org.apache.axis.NoEndPointException();
	        }
	        org.apache.axis.client.Call _call = createCall();
	        _call.setOperation(_operations[0]);
	        _call.setUseSOAPAction(true);
	        _call.setSOAPActionURI("");
	        _call.setEncodingStyle(null);
	        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
	        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
	        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
	        _call.setOperationName(new javax.xml.namespace.QName("http://test", "getHashTableValue"));

	        setRequestHeaders(_call);
	        setAttachments(_call);
	 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {podSignature});

	        if (_resp instanceof java.rmi.RemoteException) {
	            throw (java.rmi.RemoteException)_resp;
	        }
	        else {
	            extractAttachments(_call);
	            try {
	                return (IDemand) _resp;
	            } catch (java.lang.Exception _exception) {
	                return (IDemand) org.apache.axis.utils.JavaUtils.convert(_resp, Demand.class);
	            }
	        }
	  } catch (org.apache.axis.AxisFault axisFaultException) {
	  throw axisFaultException;
	}
	    }

	    public DemandSignature setHashTable(Demand poIdObj) throws java.rmi.RemoteException {
	        if (super.cachedEndpoint == null) {
	            throw new org.apache.axis.NoEndPointException();
	        }
	        org.apache.axis.client.Call _call = createCall();
	        _call.setOperation(_operations[1]);
	        _call.setUseSOAPAction(true);
	        _call.setSOAPActionURI("");
	        _call.setEncodingStyle(null);
	        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
	        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
	        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
	        _call.setOperationName(new javax.xml.namespace.QName("http://test", "setHashTable"));

	        setRequestHeaders(_call);
	        setAttachments(_call);
	 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {poIdObj});

	        if (_resp instanceof java.rmi.RemoteException) {
	            throw (java.rmi.RemoteException)_resp;
	        }
	        else {
	            extractAttachments(_call);
	            try {
	                return (DemandSignature) _resp;
	            } catch (java.lang.Exception _exception) {
	                return (DemandSignature) org.apache.axis.utils.JavaUtils.convert(_resp, DemandSignature.class);
	            }
	        }
	  } catch (org.apache.axis.AxisFault axisFaultException) {
	  throw axisFaultException;
	}
	    }

	    public IDemand getPendingDemand() throws java.rmi.RemoteException {
	        if (super.cachedEndpoint == null) {
	            throw new org.apache.axis.NoEndPointException();
	        }
	        org.apache.axis.client.Call _call = createCall();
	        _call.setOperation(_operations[2]);
	        _call.setUseSOAPAction(true);
	        _call.setSOAPActionURI("");
	        _call.setEncodingStyle(null);
	        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
	        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
	        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
	        _call.setOperationName(new javax.xml.namespace.QName("http://test", "getPendingDemand"));

	        setRequestHeaders(_call);
	        setAttachments(_call);
	 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

	        if (_resp instanceof java.rmi.RemoteException) {
	            throw (java.rmi.RemoteException)_resp;
	        }
	        else {
	            extractAttachments(_call);
	            try {
	                return (IDemand) _resp;
	            } catch (java.lang.Exception _exception) {
	                return (IDemand) org.apache.axis.utils.JavaUtils.convert(_resp, Demand.class);
	            }
	        }
	  } catch (org.apache.axis.AxisFault axisFaultException) {
	  throw axisFaultException;
	}
	    }

		@Override
		public DemandSignature setHashTable(IDemand poIDObj) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

	}


