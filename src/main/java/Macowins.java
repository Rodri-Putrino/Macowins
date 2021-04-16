import java.util.ArrayList;

class EmpresaDeRopa {
    ArrayList<Venta> listaDeVentas = new ArrayList<>();

    int precioDeVenta(Prenda prenda) {
        return prenda.precio();
    }

    void registrarVenta(Venta venta) {
        listaDeVentas.add(venta);
    }

/*  int gananciaDelDia(int dia) {
        ...
    } */
}

abstract class Prenda {
    int precio;
    Estado estado;

    int precio() {
        return precio - estado.descuento(precio);
    }
}

class Saco extends Prenda {

}

class Taco extends Prenda {

}

class Pantalon extends Prenda {

}

interface Estado {
    int descuento(int precio);
}

class Nueva implements Estado {
    public int descuento(int precio) {
        return 0;
    }
}

class Promocion implements Estado {
    int valorDescuento;

    public int descuento(int precio) {
        return valorDescuento;
    }

    void setValorDescuento(int valorDescuento) {
        this.valorDescuento = valorDescuento;
    }
}

class Liquidacion implements Estado {
    int porcentajeLiquidacion = 50;

    public int descuento(int precio) {
        return (precio * porcentajeLiquidacion) / 100 ;
    }
}

class Venta {
    ArrayList<Prenda> listaDePrendas = new ArrayList<>();
    int fechaDeVenta;
    ModoDePago modoDePago;

    void Venta(ArrayList listaDePrendas, int fechaDeVenta, ModoDePago modoDePago) {
        this.listaDePrendas = listaDePrendas;
        this.fechaDeVenta = fechaDeVenta;
        this.modoDePago = modoDePago;
    }

    int getFechaDeVenta() {
        return fechaDeVenta;
    }

    int cantidadDePrendas() {
        return listaDePrendas.size();
    }
}

interface ModoDePago {
    int recargo();
}

class Efectivo implements ModoDePago {
    public int recargo() {
        return 0;
    }
}

class Tarjeta implements  ModoDePago {
    int cantidadDeCuotas;
    int coeficienteFijo;

    void setCuotas(int cantidadDeCuotas) {
        this.cantidadDeCuotas = cantidadDeCuotas;
    }

    public void setCoeficienteFijo(int coeficienteFijo) {
        this.coeficienteFijo = coeficienteFijo;
    }

    public int recargo() {
        return cantidadDeCuotas * coeficienteFijo + this.recargoPorPrenda();
    }

    int recargoPorPrenda() {
        // ...
    }
}