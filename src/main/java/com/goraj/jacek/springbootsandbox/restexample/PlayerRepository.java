package com.goraj.jacek.springbootsandbox.restexample;

import org.springframework.data.jpa.repository.JpaRepository;

interface PlayerRepository  extends JpaRepository<Player, Long> {

}
