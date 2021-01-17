package com.spring.cg.service;

import java.util.Date;

import com.spring.cg.exception.RequestNotApproved;
import com.spring.cg.exception.UserNotFoundException;
import com.spring.cg.json.VoterRequest;

public interface VoterRequestService {
	
	public VoterRequest approveVoterRequest (VoterRequest voterRequest) throws RequestNotApproved;
	public VoterRequest addVoterRequest(VoterRequest voterRequest) ;
	public VoterRequest approveVoterRequestt (int id ) throws RequestNotApproved;
}
