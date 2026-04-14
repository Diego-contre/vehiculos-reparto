# 🚚 Sistema de Vehículos de Reparto

## 📋 Descripción del proyecto

Sistema de gestión de vehículos de reparto desarrollado en Java como consola interactiva. Permite registrar, consultar y administrar distintos tipos de vehículos (camiones, furgones y motos de reparto) mediante un menú de opciones.

---

## 🎯 Objetivo del challenger

Aplicar los pilares fundamentales de la **Programación Orientada a Objetos (POO)** en un sistema funcional, integrando encapsulación, herencia y polimorfismo en un contexto real de gestión de flota.

---

## 🧠 Conceptos POO aplicados

### 1. Encapsulación
Todos los atributos de las clases son `private`. El acceso y modificación se realiza únicamente a través de **getters** y **setters**, con validaciones incluidas cuando corresponde (por ejemplo, no permitir capacidad negativa o patente vacía).

### 2. Herencia
Se define una clase base `Vehiculo` con los atributos y comportamientos comunes. Las clases hijas (`Camion`, `Furgon`, `MotoReparto`) extienden esta clase y agregan sus propios atributos específicos mediante `extends`.

### 3. Polimorfismo por sobrescritura
Cada clase hija sobreescribe el método `mostrarDetalle()` usando `@Override`, permitiendo que al recorrer una lista de vehículos, cada objeto ejecute su propia versión del método de forma automática.

---

## 🗂️ Clases utilizadas

| Clase | Tipo | Descripción |
|---|---|---|
| `Vehiculo` | Superclase | Atributos y comportamientos comunes a todos los vehículos |
| `Camion` | Subclase | Extiende `Vehiculo`, agrega número de ejes |
| `Furgon` | Subclase | Extiende `Vehiculo`, agrega volumen interior |
| `MotoReparto` | Subclase | Extiende `Vehiculo`, agrega si tiene caja térmica |
| `Main` | Principal | Contiene el menú interactivo y la lógica de gestión |

---

## ▶️ Cómo ejecutar el programa

**Requisitos:**
- Java JDK 8 o superior
- IntelliJ IDEA (recomendado) o cualquier IDE compatible con Java

**Pasos:**
1. Clonar el repositorio
```bash
git clone <url-del-repositorio>
```
2. Abrir el proyecto en IntelliJ IDEA
3. Ejecutar la clase `Main.java`

---

## 🖥️ Ejemplo de uso del menú

```
=== SISTEMA DE VEHÍCULOS DE REPARTO ===
1. Registrar camión
2. Registrar furgón
3. Registrar moto de reparto
4. Mostrar todos los vehículos
5. Mostrar vehículos disponibles
6. Marcar vehículo como no disponible
7. Mostrar reporte general
8. Salir
Opción: 1

--- Registrar Camión ---
Patente: AB-12-34
Marca: Volvo
Modelo: FH16
Capacidad de carga (kg): 15000
Número de ejes: 6
✅ Camión registrado.
```

---

## 👥 Integrantes del equipo

- Javiera Godoy
- Diego Contreras
- Javiera Gallegos
- Victor Erazo
- Sherina Ponce
- Alexander Hass
