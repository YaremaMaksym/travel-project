package com.xsakon.travelproject.registration;

public record RegistrationRequest(String firstName,
                                  String lastName,
                                  String email,
                                  String password) {}

