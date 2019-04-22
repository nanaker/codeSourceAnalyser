

package laboratory.sniffer.detector.entities;

import laboratory.sniffer.detector.analyzer.InvocationData;
import laboratory.sniffer.detector.analyzer.VariableData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DetectorMethod extends Entity{
    private DetectorClass detectorClass;
    private String returnType;
    private Set<DetectorVariable> usedVariables;
    private Set<Entity> calledMethods;
    private DetectorModifiers modifier;
    private  int numberOfLines;
    private ArrayList<VariableData> usedVariablesData;
    private ArrayList<InvocationData> invocationData;
    private int complexity;
    private int numberOfDeclaredLocals;
    private List<DetectorArgument> arguments;
    private boolean isConstructor;
    private boolean isGetter;
    private boolean isSetter;
    private boolean isStatic;
    private boolean isOverride;

    public boolean isOverride() {
        return isOverride;
    }

    public void setOverride(boolean override) {
        isOverride = override;
    }

    public String getReturnType() {
        return returnType;
    }

    public DetectorModifiers getModifier() {
        return modifier;
    }

    private DetectorMethod(String name, DetectorModifiers modifier, String returnType, DetectorClass detectorClass) {
        this.setName(name);
        this.detectorClass = detectorClass;
        this.usedVariables = new HashSet<>();
        this.calledMethods = new HashSet<>();
        this.arguments = new ArrayList<>();
        this.modifier = modifier;
        this.returnType = returnType;
        this.numberOfLines=0;
        this.usedVariablesData = new ArrayList<>();
        this.invocationData =new ArrayList<>();
        this.complexity =0 ;
        this.numberOfDeclaredLocals=0;
        this.isConstructor=false;
        this.isSetter=false;
        this.isGetter=false;
        this.isStatic=false;
        this.isOverride=false;
    }

    public static DetectorMethod createDetectorMethod(String name, DetectorModifiers modifier, String returnType, DetectorClass detectorClass) {
        DetectorMethod detectorMethod = new DetectorMethod(name, modifier, returnType, detectorClass);
        detectorClass.addDetectorMethod(detectorMethod);
        return detectorMethod;
    }

    public DetectorClass getDetectorClass() {
        return detectorClass;
    }

    public void setDetectorClass(DetectorClass detectorClass) {
        this.detectorClass = detectorClass;
    }

    @Override
    public String toString() {
        return this.getName() + "#" + detectorClass;
    }

    public void useVariable(DetectorVariable detectorVariable) {
        usedVariables.add(detectorVariable);
    }

    public Set<DetectorVariable> getUsedVariables(){
        return this.usedVariables;
    }

    public void callMethod(Entity detectorMethod) { calledMethods.add(detectorMethod);}

    public Set<Entity> getCalledMethods() { return this.calledMethods; }

    public boolean haveCommonFields(DetectorMethod detectorMethod){
        Set<DetectorVariable> otherVariables = detectorMethod.getUsedVariables();
        for(DetectorVariable detectorVariable : usedVariables){
            if(otherVariables.contains(detectorVariable)) return true;
        }
        return false;
    }

    public void addArgument(DetectorArgument detectorArgument){
        this.arguments.add(detectorArgument);
    }

    public List<DetectorArgument> getArguments(){
        return arguments;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public void setUsedVariables(Set<DetectorVariable> usedVariables) {
        this.usedVariables = usedVariables;
    }

    public ArrayList<InvocationData> getInvocationData() {
        return invocationData;
    }

    public void setInvocationData(ArrayList<InvocationData> invocationData) {
        this.invocationData = invocationData;
    }

    public ArrayList<VariableData> getUsedVariablesData() {
        return usedVariablesData;
    }

    public void setUsedVariablesData(ArrayList<VariableData> usedVariablesData) {
        this.usedVariablesData = usedVariablesData;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getNumberOfDeclaredLocals() {
        return numberOfDeclaredLocals;
    }

    public void setNumberOfDeclaredLocals(int numberOfDeclaredLocals) {
        this.numberOfDeclaredLocals = numberOfDeclaredLocals;
    }

    public boolean isConstructor() {
        return isConstructor;
    }

    public void setConstructor(boolean constructor) {
        isConstructor = constructor;
    }

    public boolean isGetter() {
        return isGetter;
    }

    public void setGetter(boolean getter) {
        isGetter = getter;
    }

    public boolean isSetter() {
        return isSetter;
    }

    public void setSetter(boolean setter) {
        isSetter = setter;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }
}
