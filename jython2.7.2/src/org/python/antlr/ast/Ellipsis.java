// Autogenerated AST node
package org.python.antlr.ast;

import org.antlr.runtime.Token;
import org.python.antlr.PythonTree;
import org.python.antlr.base.slice;
import org.python.core.ArgParser;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyStringMap;
import org.python.core.PyType;
import org.python.expose.ExposedGet;
import org.python.expose.ExposedMethod;
import org.python.expose.ExposedNew;
import org.python.expose.ExposedType;

@ExposedType(name = "_ast.Ellipsis", base = slice.class)
public class Ellipsis extends slice {
public static final PyType TYPE = PyType.fromClass(Ellipsis.class);

    private final static PyString[] fields = new PyString[0];
    @ExposedGet(name = "_fields")
    public PyString[] get_fields() { return fields; }

    private final static PyString[] attributes = new PyString[0];
    @ExposedGet(name = "_attributes")
    public PyString[] get_attributes() { return attributes; }

    public Ellipsis(PyType subType) {
        super(subType);
    }
    @ExposedNew
    @ExposedMethod
    public void Ellipsis___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("Ellipsis", args, keywords, new String[]
            {}, 0, true);
    }

    public Ellipsis() {
    }

    public Ellipsis(Token token) {
        super(token);
    }

    public Ellipsis(Integer ttype, Token token) {
        super(ttype, token);
    }

    public Ellipsis(PythonTree tree) {
        super(tree);
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "Ellipsis";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Ellipsis(");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitEllipsis(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
    }

    public PyObject __dict__;

    @Override
    public PyObject fastGetDict() {
        ensureDict();
        return __dict__;
    }

    @ExposedGet(name = "__dict__")
    public PyObject getDict() {
        return fastGetDict();
    }

    private void ensureDict() {
        if (__dict__ == null) {
            __dict__ = new PyStringMap();
        }
    }

}