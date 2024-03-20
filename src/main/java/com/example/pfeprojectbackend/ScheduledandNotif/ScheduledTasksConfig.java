package com.example.pfeprojectbackend.ScheduledandNotif;

import com.example.pfeprojectbackend.service.IServiceObjectif;
import com.example.pfeprojectbackend.service.ServiceObjectif;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling

@RequiredArgsConstructor
public class ScheduledTasksConfig {


    private final IServiceObjectif serviceObjectif;



    @Scheduled(cron = "0 0 9 * * MON-FRI")
    public void sendProgressUpdateAlert(){

            serviceObjectif.sendProgressUpdateAlert();
    }




}
