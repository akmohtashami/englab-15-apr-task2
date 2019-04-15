package selab.mvc.models;

public abstract class Model {
    private DataSet dataSet = null;
    public void bind(DataSet dataSet) {
        if (this.dataSet != null)
            throw new IllegalArgumentException("Already bound to context");
        this.dataSet = dataSet;
    }
    protected DataSet getDataSet() {
        if (this.dataSet == null)
            throw new IllegalStateException("Model not bound");
        return this.dataSet;
    }

    protected DataContext getDataContext() {
        return this.getDataSet().getDataContext();
    }

    public abstract String getPrimaryKey();

    public void remove() {
        this.getDataSet().remove(this);
    }
}
