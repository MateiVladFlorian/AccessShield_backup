package core;

import Entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vlad
 */
public class LoadsTablesData 
{
    private ManagerEntities em;
    
    public LoadsTablesData() 
    {
        em = new ManagerEntities();
    }
    
    public List<Account> Load_Account_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM account", Account.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<Building> Load_Builds_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM building", Building.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<UserProfile> Load_UserProfile_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM user_profile", UserProfile.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<UserIdentifier> Load_UserIdentifier_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM user_identifier", UserIdentifier.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<RoomsAmenities> Load_Amenities_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM rooms_amenities", RoomsAmenities.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<Rooms> Load_Rooms_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM rooms", Rooms.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<SecurityLogs> Load_SecurityLogs_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM security_logs", SecurityLogs.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<UsersRoles> Load_UsersRoles_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM users_roles", UsersRoles.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    
    public List<Transactions> Load_Transactions_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM transactions", Transactions.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<AccessRoom> Load_AccessRoom_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM access_room", AccessRoom.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<Notifications> Load_Notifications_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM notifications", Notifications.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<UsersSessions> Load_UsersSessions_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM users_sessions", UsersSessions.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<Reservations> Load_Reservations_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM reservations", Reservations.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<Payments> Load_Payments_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM payments", Payments.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<TransactionAuditLogs> Load_TransactionAuditLogs_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM Transaction_audit_logs", TransactionAuditLogs.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<RoomServices> Load_RoomServices_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM room_services", RoomServices.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<RoomAccessCards> Load_RoomAccessCards_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM room_access_cards", RoomAccessCards.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<Reviews> Load_Reviews_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM reviews", Reviews.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<ReservationsHistory> Load_ReservationsHistory_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM reservations_history", ReservationsHistory.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<Promotions> Load_Promotions_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM promotions", Promotions.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    } 
    public List<PaymentMethods> Load_PaymentMethods_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM payment_methods", PaymentMethods.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<PaymentGateways> Load_PaymentGateways_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM payment_gateways", PaymentGateways.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<NotificationEvents> Load_NotificationEvents_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM notification_events", NotificationEvents.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<MaintenanceLogs> Load_MaintenanceLogs_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM maintenance_logs", MaintenanceLogs.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<EventLogs> Load_EventLogs_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM event_logs", EventLogs.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<BillingInfo> Load_BillingInfo_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM billing_info", BillingInfo.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
    public List<AccessLogs> Load_AccessLogs_TableData()
    {
        try { return em.getManagerEntities().createNativeQuery("SELECT * FROM access_logs", AccessLogs.class).getResultList(); } 
        catch (Exception e) { e.printStackTrace(); return new ArrayList<>(); }
    }
}
