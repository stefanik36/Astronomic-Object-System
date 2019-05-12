package com.agh.aos.model;

import org.jscience.geography.coordinates.XYZ;
import org.jscience.mathematics.vector.Float64Vector;
import org.jscience.physics.amount.Amount;

import javax.measure.VectorMeasure;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Velocity;
import javax.measure.unit.Unit;

import static javax.measure.unit.SI.*;


public class AstronomicObject {
    private String name;

    private Amount<Length> radius;
    private Amount<Mass> mass;

    private XYZ position;

    private VectorMeasure<Velocity> velocity;

    public AstronomicObject(String name, Amount<Length> radius, Amount<Mass> mass, XYZ position, VectorMeasure<Velocity> velocity) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
    }

    public void move() {
        this.position = XYZ.valueOf(position.toVector(METER).plus(Float64Vector.valueOf(velocity.getValue())), METER);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount<Length> getRadius() {
        return radius;
    }

    public void setRadius(Amount<Length> radius) {
        this.radius = radius;
    }

    public Amount<Mass> getMass() {
        return mass;
    }

    public void setMass(Amount<Mass> mass) {
        this.mass = mass;
    }

    public XYZ getPosition() {
        return position;
    }

    public void setPosition(XYZ position) {
        this.position = position;
    }

    public VectorMeasure<Velocity> getVelocity() {
        return velocity;
    }

    public void setVelocity(VectorMeasure<Velocity> velocity) {
        this.velocity = velocity;
    }

}
