package com.app.kp.ai.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KPResponse {

	private LocalDate date;
	private LocalTime time;
	private double latitude;
	private double longitude;
	private double timezone;
	List<PlanetPosition> calculatePlanets;
	List<Cusp> calculateCusps;

	public KPResponse(List<PlanetPosition> calculatePlanets, List<Cusp> calculateCusps) {
		this.calculatePlanets = calculatePlanets;
		this.calculateCusps = calculateCusps;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getTimezone() {
		return timezone;
	}

	public void setTimezone(double timezone) {
		this.timezone = timezone;
	}

	public List<PlanetPosition> getCalculatePlanets() {
		return calculatePlanets;
	}

	public void setCalculatePlanets(List<PlanetPosition> calculatePlanets) {
		this.calculatePlanets = calculatePlanets;
	}

	public List<Cusp> getCalculateCusps() {
		return calculateCusps;
	}

	public void setCalculateCusps(List<Cusp> calculateCusps) {
		this.calculateCusps = calculateCusps;
	}

}
