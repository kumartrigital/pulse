package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.Training;

public interface TrainingService {
	int count();

	int saveTraining(Training training);

	int updateTraining(Training training);

	int deleteById(Long id);

	List<Training> getAllTrainings();

	int saveToLog(long capabilityID, String action);

	long getRecordId(String trainingName, String trainingId);

	int publishTraining(long id,String comment);

	int deleteTraining(Long id);
	List<Training> trainigSearch(Training training);
	long existingTraining(String trainigId);

}
