/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author gilbert.solorzano
 */
@XmlSeeAlso(ExMethodParameterTransformer.class)
public class ExInfoPointMetricDefinition {
    private ExMethodParameterTransformer methodParameterTransformer;
    private String name,rollupType;
    
    public ExInfoPointMetricDefinition(){}

    @XmlElement(name=AppExportS.METHOD_PARAMETER_TRANSFORMER)
    public ExMethodParameterTransformer getMethodParameterTransformer() {
        return methodParameterTransformer;
    }

    public void setMethodParameterTransformer(ExMethodParameterTransformer methodParameterTransformer) {
        this.methodParameterTransformer = methodParameterTransformer;
    }

    @XmlElement(name=AppExportS.NAME)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name=AppExportS.ROLLUP_TYPE)
    public String getRollupType() {
        return rollupType;
    }

    public void setRollupType(String rollupType) {
        this.rollupType = rollupType;
    }
    
    public String whatIsDifferent(ExInfoPointMetricDefinition obj){
        
        if(this.equals(obj)) return AppExportS._U;
        
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3).append(AppExportS.INFO_POINT_METRIC_DEFINITION);
        bud.append(AppExportS.L3_1).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        
        if(!rollupType.equals(obj.getRollupType())){         
            bud.append(AppExportS.L4_1).append(AppExportS.ROLLUP_TYPE);
            bud.append(AppExportS.L5).append(AppExportS.SRC).append(AppExportS.VE).append(rollupType);
            bud.append(AppExportS.L5).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getRollupType()); 
        }
        
        bud.append(methodParameterTransformer.whatIsDifferent(obj.getMethodParameterTransformer()));
        
        
        return bud.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3).append(AppExportS.INFO_POINT_METRIC_DEFINITION);
        bud.append(AppExportS.L3_1).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        bud.append(AppExportS.L3_1).append(AppExportS.ROLLUP_TYPE).append(AppExportS.VE).append(rollupType);
        bud.append(methodParameterTransformer);
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.methodParameterTransformer != null ? this.methodParameterTransformer.hashCode() : 0);
        hash = 83 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 83 * hash + (this.rollupType != null ? this.rollupType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExInfoPointMetricDefinition other = (ExInfoPointMetricDefinition) obj;
        if (this.methodParameterTransformer != other.methodParameterTransformer && (this.methodParameterTransformer == null || !this.methodParameterTransformer.equals(other.methodParameterTransformer))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.rollupType == null) ? (other.rollupType != null) : !this.rollupType.equals(other.rollupType)) {
            return false;
        }
        return true;
    }
    
    
    
}
