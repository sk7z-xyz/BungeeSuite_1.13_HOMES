package com.minecraftdimensions.bungeesuitehomes.listeners;

import com.minecraftdimensions.bungeesuitehomes.managers.PermissionsManager;
import com.minecraftdimensions.bungeesuitehomes.managers.HomesManager;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class HomesListener implements Listener {

    @EventHandler( priority = EventPriority.HIGHEST )
    public void playerConnect( PlayerJoinEvent e ) {
        //e.getPlayer().sendMessage("[home_debug] homeコマンドによる接続かチェック");
        //System.out.println("[home_debug] homeコマンドによる接続かチェック");
        if ( HomesManager.pendingTeleports.containsKey( e.getPlayer().getName() ) ) {
            Location l = HomesManager.pendingTeleports.get( e.getPlayer().getName() );
            e.getPlayer().teleport(l);
            //e.getPlayer().sendMessage(l.toString());
            ///e.getPlayer().sendMessage("[home_debug] 保留リストに存在しているプレイヤーののためテレポート");
            //System.out.println("[home_debug] 保留リストに存在しているプレイヤーののためテレポート");
        }else{
            //e.getPlayer().sendMessage("[home_debug] 保留リストに存在しないプレイヤーです。");
            //System.out.println("[home_debug] 保留リストに存在しないプレイヤーです。");
        }
    }

    @EventHandler( priority = EventPriority.NORMAL )
    public void setPermissionGroup( final PlayerLoginEvent e ) {
        if ( e.getPlayer().hasPermission( "bungeesuite.*" ) ) {
            PermissionsManager.addAllPermissions( e.getPlayer() );
        } else if ( e.getPlayer().hasPermission( "bungeesuite.admin" ) ) {
            PermissionsManager.addAdminPermissions( e.getPlayer() );
        } else if ( e.getPlayer().hasPermission( "bungeesuite.user" ) ) {
            PermissionsManager.addUserPermissions( e.getPlayer() );
        }
    }

}
