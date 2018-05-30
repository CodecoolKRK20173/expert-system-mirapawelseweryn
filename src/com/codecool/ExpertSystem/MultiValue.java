import java.util.List;

public class MultiValue extends Value {

  private List<String> list;
  private boolean selectionType;

  MultiValue(String param, boolean selectionType) {
    this.list = Arrays.asList(param.split(","));
    this.selectionType = selectionType;
  }

  // @Override
  public List<String> getInputPattern() {
    return list;
  }

  // @Override
  public boolean getSelectionType() {
    return selectionType;
  }
}
