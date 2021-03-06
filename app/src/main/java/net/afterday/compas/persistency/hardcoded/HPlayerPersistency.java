package net.afterday.compas.persistency.hardcoded;

import net.afterday.compas.core.player.Player;
import net.afterday.compas.persistency.player.PlayerPersistency;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by spaka on 6/14/2018.
 */
public class HPlayerPersistency implements PlayerPersistency
{
    private Map<String, Player.FRACTION> fractions = new HashMap<>();
    private Map<String, Player.COMMAND> commands = new HashMap<>();

    public HPlayerPersistency()
    {
        setupFractions();
        setupCommands();
    }

    public Player.FRACTION getFractionByCode(String code)
    {
        if(fractions.containsKey(code))
        {
            return fractions.get(code);
        }
        return null;
    }

    @Override
    public Player.COMMAND getCommandByCode(String code)
    {
        if(commands.containsKey(code))
        {
            return commands.get(code);
        }
        return null;
    }

    private void setupFractions()
    {
        fractions.put("MONOLITH953", Player.FRACTION.MONOLITH); //Режим монолитовца
        fractions.put("GAMEMASTER751", Player.FRACTION.GAMEMASTER); //Режим игромастера
        fractions.put("STALKER982", Player.FRACTION.STALKER); //Режим обычного игрока
        fractions.put("DARKEN256", Player.FRACTION.DARKEN); //Режим Тёмного

    }
    private void setupCommands()
    {
        commands.put("KILL492", Player.COMMAND.KILL); //Убить игрока
        commands.put("REVIVE856", Player.COMMAND.REVIVE); //Оживить игрока
    }

}
