package com.alura.api.Response;

public class ApiResponse {
    private String Action;
    private String State;
    private String Message;

    public ApiResponse(String Action, boolean State, String Message){
        this.Action = Action;
        this.Message = Message;
        if (State) this.State = "Successfully";
        else this.State = "Not Found";
    }

    public String getAction() {
        return Action;
    }

    public String getState() {
        return State;
    }

    public String getMessage() {
        return Message;
    }
}
