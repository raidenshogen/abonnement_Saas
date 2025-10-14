package org.ang.projet_abonnement_saas.serviceAbonnemet.service.Implimentation;

import org.ang.projet_abonnement_saas.serviceAbonnemet.domain.entity.Subscription;
import org.ang.projet_abonnement_saas.serviceAbonnemet.repository.SubscriptionRepository;
import org.ang.projet_abonnement_saas.serviceAbonnemet.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

    @Autowired
     private SubscriptionRepository subscriptionRepo;

   @Override
    public Subscription CreateSubscription(Subscription subscription){

        return subscriptionRepo.save(subscription);
    }
@Override
    public Subscription UpdateSubscriptionStatus(Subscription subscription){
        Subscription sub = subscriptionRepo.findById(subscription.getId()).orElse(null);
        subscription.setStatut(sub.getStatut());
        return subscriptionRepo.save(sub);
    }
@Override
    public void CancalSubscription(Subscription subscription){
        Subscription sub1= subscriptionRepo.findById(subscription.getId()).orElse(null);
         if(sub1!=null){
            sub1.setStatut(Status.cancelled);
            subscriptionRepo.save(sub1);
         }

    }
@Override
   public  Subscription RenewSubscription(Subscription subscription){
        Subscription sub1= subscriptionRepo.findById(subscription.getId()).orElse(null);
        if(sub1!=null){
            subscription.setStart_date(sub1.getStart_date());
            subscription.setEnd_date(sub1.getEnd_date());
        }
          return  subscriptionRepo.save(sub1);
   }

    @Override
    public List<Subscription>getActiveSubscriptions() {
       return  subscriptionRepo.findAll().stream().filter(e->e.getStatut().equals(Status.active))
               .collect(Collectors.toList());

   }



}




