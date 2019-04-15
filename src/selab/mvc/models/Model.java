package selab.mvc.models;

public abstract class Model {
    private DataContext dataContext = null;
    public void bind(DataContext dataContext) {
        if (this.dataContext != null)
            throw new IllegalArgumentException("Already bound to context");
        this.dataContext = dataContext;
    }
    protected DataContext getDataContext() {
        if (this.dataContext == null)
            throw new IllegalStateException("Model not bound");
        return this.dataContext;
    }
    public abstract String getPrimaryKey();
}
