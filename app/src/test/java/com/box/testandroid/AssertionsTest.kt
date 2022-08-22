package com.box.testandroid

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

/**
 * Assertions test
 *
 * @constructor Create empty Assertions test
 */
class AssertionsTest{
    /**
     * Get array test
     *
     */
    @Test
    fun getArrayTest(){
        val assertions = Assertions()
        val array = arrayOf(21, 117)// valor esperado
        //val array = arrayOf(21, 11)// valor esperado
        assertArrayEquals("mensaje personalizado de error en testing",
            array, assertions.getLuckyNumbers())
    }

    /**
     * Get name test
     *
     */
    @Test
    fun getNameTest(){
        val assertions = Assertions()
        val name = "Alain"
        val otherName = "Max"
        assertEquals(name, assertions.getName())
        assertNotEquals(otherName, assertions.getName())
    }

    /**
     * Check human test
     *
     */
    @Test
    fun checkHumanTest(){
        val assertions = Assertions()
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
    }

    /**
     * Check null user test
     *
     */
    @Test
    fun checkNullUserTest(){
        val user = null
        assertNull(user)
        val assertions = Assertions()
        assertNull(assertions.checkHuman(user))
    }

    /**
     * Check not null user test
     *
     */
    @Test
    fun checkNotNullUserTest(){
        val juan = User("Juan", 18, true)
        assertNotNull(juan)
    }

    /**
     * Check not same users test
     *
     */
    @Test
    fun checkNotSameUsersTest(){
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertNotSame(bot, juan)
    }

    /**
     * Check same users test
     * Check that both are the same object
     */
    @Test
    fun checkSameUsersTest(){
        val bot = User("Juan", 18, true)
        val juan = User("Juan", 18, true)
        val copyJuan = juan
        assertSame(copyJuan, juan)
    }

    /**
     * Get cities test
     * 1_000 => milliseconds, add rule limit response time , max is 1_000
     */
    @Test(timeout = 1_000)
    fun getCitiesTest(){
        val cities = arrayOf("México", "Perú", "Argentina")

        // simulate server delay
        Thread.sleep(Random.nextLong(200, 1_100))
        //Thread.sleep(Random.nextLong(950, 1_050))
        assertEquals(3, cities.size)
    }
}