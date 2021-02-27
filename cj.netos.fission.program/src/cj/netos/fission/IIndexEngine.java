package cj.netos.fission;

import cj.studio.ecm.net.CircuitException;

public interface IIndexEngine {
    void reindex()throws CircuitException;
    void empty()throws CircuitException;
}
