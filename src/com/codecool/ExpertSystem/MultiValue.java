public class MultiValue extends Value {

  private List<String> param;
  private boolean selectionType;

  MultiValue(List<String> param, boolean selectionType) {
    this.param = param;
    this.selectionType = selectionType;
  }

  @Override
  public List<String> getInputPattern() {
    return param;
  }

  @Override
  public boolean getSelectionType() {
    return selectionType;
  }
}
